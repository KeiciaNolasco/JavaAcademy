package academiajava.jpa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JPAUtil {

    private static SessionFactory sessionFactory;

    private JPAUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (JPAUtil.class) {
                if (sessionFactory == null) {
                    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                    sessionFactory = configuration.buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void close() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

}
