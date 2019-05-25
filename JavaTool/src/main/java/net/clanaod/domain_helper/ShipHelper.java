package net.clanaod.domain_helper;

import net.clanaod.domain.Player;
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
    public static Ship getShipByPublicString(String shipString){
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
        session.beginTransaction();
        Ship s = new Ship(shipName, shipType);
        session.saveOrUpdate(s);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteShipByPublicString(String shipString){
        Ship s = getShipByPublicString(shipString);
        List<Player> playerList = PlayerHelper.getPlayers();
        for(Player player : playerList){
            player.getShips().remove(s);
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(player);
            session.getTransaction().commit();
            session.close();
        }
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(s);
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
