package net.clanaod.domain_helper;

import net.clanaod.domain.Player;
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
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Player";
        Query query = session.createQuery(hql);
        List<Player> playerList= query.list();
        session.close();
        return playerList;
    }
    public static void deletePlayer(Player player){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        session.beginTransaction();
        player.getShips().clear();
        session.saveOrUpdate(player);
        session.delete(player);
        session.getTransaction().commit();
        session.close();
    }

    public static void savePlayer(Player player){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(player);
        session.getTransaction().commit();
        session.close();
    }
}
