package net.clanaod.util;


import net.clanaod.domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.internal.util.config.ConfigurationException;

import java.io.File;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                File f = new File(System.getProperty("user.home") +"\\WoWSCBTool");
                boolean b = f.mkdirs();
                if(b){
                f = new File(System.getProperty("user.home") +"\\WoWSCBTool\\hibernate.cfg.xml");}
                else f = new File("hibernate.cfg.xml");
                StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure(f).build();
                Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

                sessionFactory = meta.getSessionFactoryBuilder().build();
            } catch (ConfigurationException e) {
                try {

                    // Hibernate settings equivalent to hibernate.cfg.xml's properties
                    Properties properties = new Properties();
                    properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.DerbyTenSevenDialect");
                    properties.setProperty(Environment.HBM2DDL_AUTO,"update");
                    properties.setProperty(Environment.DRIVER, "org.apache.derby.jdbc.EmbeddedDriver");
                    properties.setProperty(Environment.USER, "test");
                    properties.setProperty(Environment.PASS, "test");
                    System.setProperty("derby.stream.error.field", "MyApp.DEV_NULL");
                    String user_home = System.getProperty("user.home");
                    properties.setProperty(Environment.URL, "jdbc:derby:"+user_home+"\\WoWSCBTool\\EmbededDB;create=true");
                    Configuration cfg = new Configuration();
                    cfg.setProperties(properties);
                    cfg.addAnnotatedClass(Ship.class);
                    cfg.addAnnotatedClass(Player.class);
                    cfg.addAnnotatedClass(Day.class);
                    cfg.addAnnotatedClass(PlayerPlaysDay.class);

                    sessionFactory = cfg.buildSessionFactory();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return sessionFactory;
    }
}
