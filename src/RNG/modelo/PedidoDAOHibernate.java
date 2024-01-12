package RNG.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PedidoDAOHibernate implements PedidoDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void agregarPedido(Pedido pedido) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(pedido);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPedido(int numeroPedido) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Pedido pedido = session.get(Pedido.class, numeroPedido);
            if (pedido != null) {
                session.delete(pedido);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPedidoPorNumero(int numeroPedido) {
        try {
            return session.get(Pedido.class, numeroPedido);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        try {
            return session.createQuery("FROM Pedido", Pedido.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ListaPedidos obtenerPedidosPendientes() {
        // Implementa la lÃ³gica para obtener pedidos pendientes
        // Puedes devolver una instancia de ListaPedidos con los pedidos pendientes
        return null;
    }
}