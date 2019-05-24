package net.clanaod.domain_helper;

import net.clanaod.domain.Ship;
import net.clanaod.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

@SuppressWarnings("unchecked")
public class ShipHelper {

    public static List<Ship> getAllShips(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Ship";
        Query query = session.createQuery(hql);
        List<Ship> shipList = query.list();
        session.close();
        return shipList;
    }
    public static Ship getShipByString(String shipString){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Ship where shipName = :shipName and shipType = :shipType";
        Query q = session.createQuery(hql);
        q.setParameter("shipName",shipString.split("[(|)]")[0]);
        q.setParameter("shipType",shipString.split("[(|)]")[1]);
        Ship ship = (Ship)q.getSingleResult();
        session.close();
        return ship;
    }
    private static void addShip(String shipName, String shipType){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Ship s = new Ship(shipName, shipType);
        session.saveOrUpdate(s);
        session.getTransaction().commit();
        session.close();
    }
    private static Ship getShipByStrings(String shipName, String shipType){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Ship where shipName = :shipName and shipType = :shipType";
        Query q = session.createQuery(hql);
        q.setParameter("shipName",shipName);
        q.setParameter("shipType",shipType);
        Ship ship;
        try{
            ship = (Ship)q.getSingleResult();
        }catch (NoResultException ex){
            ship=null;
        }

        session.close();
        return ship;
    }

    public static void importShip(String shipName, String shipType){
        if(getShipByStrings(shipName,shipType) == null){
            addShip(shipName,shipType);
        }
    }
}
