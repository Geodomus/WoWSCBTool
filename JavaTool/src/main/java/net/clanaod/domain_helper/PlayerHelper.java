package net.clanaod.domain_helper;

import net.clanaod.domain.Player;
import net.clanaod.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class PlayerHelper {

    public static List<Player> getPlayers(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Player";
        Query query = session.createQuery(hql);
        List<Player> playerList= query.list();
        session.close();
        return playerList;
    }
    public static void deletePlayer(Player player){
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
}
