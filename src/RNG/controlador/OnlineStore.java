package RNG.controlador;

import RNG.vista.GestionOS;
import RNG.modelo.HibernateUtil;
import org.hibernate.Session;

public class OnlineStore {
    public static void main(String[] args) {
        try {
            GestionOS gestion = new GestionOS();

            // Inicializar Hibernate (puedes hacer esto al inicio de tu aplicación)
            HibernateUtil.getSessionFactory();

            gestion.inicio();

        } finally {
            // Cerrar la sesión de Hibernate y otros recursos al finalizar la aplicación
            HibernateUtil.shutdown();
        }
    }
}