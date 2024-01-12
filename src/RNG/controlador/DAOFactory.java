// DAOFactory.java
package RNG.controlador;

import RNG.modelo.ArticuloDAO;
import RNG.modelo.ClienteDAO;
import RNG.modelo.PedidoDAO;
import RNG.modelo.ArticuloDAOHibernate;
import RNG.modelo.ClienteDAOHibernate;
import RNG.modelo.PedidoDAOHibernate;

public class DAOFactory {

    private static final String DATABASE_TYPE = "Hibernate"; // Cambiado a Hibernate

    public static ClienteDAO getClienteDAO() {
        // Implementa lógica específica para Hibernate
        if (DATABASE_TYPE.equals("Hibernate")) {
            return new ClienteDAOHibernate();
        }

        throw new UnsupportedOperationException("Tipo de base de datos no soportado: " + DATABASE_TYPE);
    }

    public static ArticuloDAO getArticuloDAO() {
        // Implementa lógica específica para Hibernate
        if (DATABASE_TYPE.equals("Hibernate")) {
            return new ArticuloDAOHibernate();
        }

        throw new UnsupportedOperationException("Tipo de base de datos no soportado: " + DATABASE_TYPE);
    }

    public static PedidoDAO getPedidoDAO() {
        // Implementa lógica específica para Hibernate
        if (DATABASE_TYPE.equals("Hibernate")) {
            return new PedidoDAOHibernate();
        }

        throw new UnsupportedOperationException("Tipo de base de datos no soportado: " + DATABASE_TYPE);
    }
}
