package RNG.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClienteDAOHibernate implements ClienteDAO {
    private Session session; // Agrega este campo

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(String correoElectronicoCliente) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Cliente cliente = buscarClientePorCorreo(correoElectronicoCliente);
            if (cliente != null) {
                session.delete(cliente);
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
    public Cliente buscarClientePorCorreo(String correoElectronico) {
        try {
            return session.get(Cliente.class, correoElectronico);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        try {
            return session.createQuery("FROM Cliente", Cliente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}