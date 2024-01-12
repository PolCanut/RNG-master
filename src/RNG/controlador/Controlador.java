package RNG.controlador;

import RNG.modelo.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Controlador {

    private final ClienteDAO clienteDAO;
    private final ArticuloDAO articuloDAO;
    private final PedidoDAO pedidoDAO;
    private final Datos datos;

    public Controlador() {
        clienteDAO = DAOFactory.getClienteDAO();
        articuloDAO = DAOFactory.getArticuloDAO();
        pedidoDAO = DAOFactory.getPedidoDAO();
        datos = new Datos();
    }

    private <T> T executeInTransaction(TransactionOperation<T> operation) {
        Transaction transaction = null;
        T result = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            result = operation.execute(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return result;
    }

    // Métodos para interactuar con los datos

    public void agregarArticulo(Articulo articulo) {
        executeInTransaction(session -> {
            articuloDAO.setSession(session);
            articuloDAO.agregarArticulo(articulo);
            return null;
        });
    }

    public ListaPedidos getListaPedidosPendientes() {
        ListaPedidos lista = executeInTransaction(session -> pedidoDAO.obtenerPedidosPendientes());
        ListaPedidos lista2 = new ListaPedidos();

        for (int i = 0; i < lista.getSize(); i++) {
            if (!lista.getAt(i).pedidoEnviado()) {
                lista2.add(lista.getAt(i));
            }
        }
        return lista2;
    }

    public void eliminarArticulo(String codigoArticulo) {
        executeInTransaction(session -> {
            articuloDAO.setSession(session);
            articuloDAO.eliminarArticulo(codigoArticulo);

            return null;
        });
    }

    public void agregarCliente(Cliente cliente) {
        executeInTransaction(session -> {
            clienteDAO.setSession(session);
            clienteDAO.agregarCliente(cliente);
            return null;
        });
    }

    public void eliminarCliente(String correoElectronicoCliente) {
        executeInTransaction(session -> {
            clienteDAO.setSession(session);
            clienteDAO.eliminarCliente(correoElectronicoCliente);
            return null;
        });
    }

    public Datos getDatos() {
        return datos;
    }

    public void agregarPedido(Pedido pedido) {
        executeInTransaction(session -> {
            pedidoDAO.setSession(session);
            pedidoDAO.agregarPedido(pedido);
            return null;
        });
    }

    public void eliminarPedido(int numeroPedido) {
        executeInTransaction(session -> {
            pedidoDAO.setSession(session);
            pedidoDAO.eliminarPedido(numeroPedido);
            return null;
        });
    }

    public Cliente buscarClientePorCorreo(String correo) {
        return executeInTransaction(session -> clienteDAO.buscarClientePorCorreo(correo));
    }

    public Articulo buscarArticuloPorCodigo(String codigoArticulo) {
        return executeInTransaction(session -> articuloDAO.buscarArticuloPorCodigo(codigoArticulo));
    }

    public void update() {
    }

    interface TransactionOperation<T> {
        T execute(Session session);
    }
}
