package RNG.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ArticuloDAOHibernate implements ArticuloDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void agregarArticulo(Articulo articulo) {
        try {
            session.save(articulo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarArticulo(String codigoArticulo) {
        try {
            Articulo articulo = session.get(Articulo.class, codigoArticulo);
            if (articulo != null) {
                session.delete(articulo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Articulo buscarArticuloPorCodigo(String codigoArticulo) {
        try {
            return session.get(Articulo.class, codigoArticulo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Articulo> obtenerTodosLosArticulos() {
        try {
            return session.createQuery("FROM Articulo", Articulo.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}