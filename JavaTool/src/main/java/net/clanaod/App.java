package net.clanaod;

import net.clanaod.domain.Player;
import net.clanaod.domain.Ship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        //Player p1 = session.get(Player.class, "Geodomus");
        Player p1 = new Player("Taffy", "test");
        Ship s2 = session.get(Ship.class, "GK");
        p1.addShip(s2);
        session.save(p1);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}
