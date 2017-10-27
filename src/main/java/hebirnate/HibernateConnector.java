package hebirnate;

import lombok.Getter;
import models.Player;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
public class HibernateConnector {
    private static HibernateConnector connector;
    private Configuration configuration;
    private SessionFactory sessionFactory;

    private HibernateConnector() {
        configuration = new Configuration();

        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/javahebirnatedatabase");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "BVB09");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");

        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//        configuration.configure("hibernate.cfg.xml");

        configuration.addResource("Club.hbm.xml");
        configuration.addResource("NationalTeam.hbm.xml");
        configuration.addAnnotatedClass(Player.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    static {
        connector = new HibernateConnector();
    }

    public static HibernateConnector getConnector() {
        return connector;
    }

    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException {
        this.sessionFactory = configuration.buildSessionFactory();
    }
}