package net.clanaod.domain_helper;

import net.clanaod.domain.Player;
import net.clanaod.domain.PlayerPlaysDay;
import net.clanaod.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("unchecked")
public class PlayerHelper {

    public static List<Player> getPlayers(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Player";
        Query query = session.createQuery(hql);
        List<Player> playerList= query.list();
        session.close();
        return playerList;
    }
    public static void deletePlayer(Player player){
        deletePlayerDays(player);
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        player.getShips().clear();
        session.saveOrUpdate(player);
        session.delete(player);
        session.getTransaction().commit();
        session.close();
    }

    public static void savePlayer(Player player){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(player);
        session.getTransaction().commit();
        session.close();
    }

    public static void deletePlayerDays(Player player){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        String hql = "FROM PlayerPlaysDay where player = :player";
        Query q = session.createQuery(hql);
        q.setParameter("player",player);
        List<PlayerPlaysDay> playerList= q.list();
        for(PlayerPlaysDay ppd : playerList){
            session.delete(ppd);
        }
        session.getTransaction().commit();
        session.close();
    }
}
