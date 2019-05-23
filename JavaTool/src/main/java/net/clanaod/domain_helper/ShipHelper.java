package net.clanaod.domain_helper;

import net.clanaod.domain.Ship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class ShipHelper {

    public static List<Ship> getAllShips(){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Ship";
        Query query = session.createQuery(hql);
        List<Ship> shipList = query.list();
        session.close();
        return shipList;
    }
    public static Ship getShipByString(String shipString){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Ship where shipName = :shipName and shipType = :shipType";
        Query q = session.createQuery(hql);
        String[] sa = shipString.split("[\\(||\\)]");
        System.out.println(sa);
        q.setParameter("shipName",shipString.split("[\\(||\\)]")[0]);
        q.setParameter("shipType",shipString.split("[\\(||\\)]")[1]);
        Ship ship = (Ship)q.getSingleResult();
        session.close();
        return ship;
    }
    public static void addShip(String shipName, String shipType){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Ship s = new Ship(shipName, shipType);
        session.saveOrUpdate(s);
        session.getTransaction().commit();
        session.close();
    }
}
