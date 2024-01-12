package RNG.modelo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // ConfiguraciÃ³n de Hibernate usando hibernate.cfg.xml
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();

            // Construir la SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Error al inicializar la SessionFactory de Hibernate");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Cerrar la SessionFactory y liberar los recursos
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}