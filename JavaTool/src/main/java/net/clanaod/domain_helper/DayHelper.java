package net.clanaod.domain_helper;

import net.clanaod.domain.Day;
import net.clanaod.domain.Player;
import net.clanaod.domain.PlayerPlaysDay;
import net.clanaod.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class DayHelper {

    public static Day getDayByName(String dayName){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Day where weekday = :weekday";
        Query q = session.createQuery(hql);
        q.setParameter("weekday",dayName);
        Day day;
        try{
             day = (Day)q.getSingleResult();
        }catch (NoResultException ex){
            day=null;
        }
        session.close();
        return day;
    }

    public static Day getDayByNumber(byte dayNumber){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Day where dayNumber = :dayNumber";
        Query q = session.createQuery(hql);
        q.setParameter("dayNumber",dayNumber);
        Day day;
        try{
            day = (Day)q.getSingleResult();
        }catch (NoResultException ex){
            day=null;
        }
        session.close();
        return day;
    }

    private static void addDay(String dayName, byte dayNumber){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Day day = new Day();
        day.setWeekday(dayName);
        day.setDayNumber(dayNumber);
        session.saveOrUpdate(day);
        session.getTransaction().commit();
        session.close();
    }

    public static void importDay(String dayName,byte dayNumber){
        if(getDayByName(dayName) == null){
            addDay(dayName, dayNumber);
        }
    }

    public static List<Day> getAllDays(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        String hql = "FROM Day";
        Query q = session.createQuery(hql);
        List<Day> days = q.list();
        session.close();
        return days;
    }

    public static void savePlayerPlaysDay(PlayerPlaysDay pd){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(pd);
        session.getTransaction().commit();
        session.close();
    }

    public static PlayerPlaysDay getTimeByPlayerAndDayNumber(Player player,byte dayNumber){

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        String hql = "select ppd FROM PlayerPlaysDay as ppd inner join ppd.day as day where day.dayNumber = :dayNumber and ppd.player = :player";
        Query q = session.createQuery(hql);
        q.setParameter("dayNumber",dayNumber);
        q.setParameter("player",player);
        PlayerPlaysDay ppd;
        try{
            ppd = (PlayerPlaysDay)q.getSingleResult();
        }catch (NoResultException ex){
            ppd=null;
        }
        session.close();
        return ppd;
    }

    public static void deletePlayerPlaysDay(PlayerPlaysDay pd){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(pd);
        session.getTransaction().commit();
        session.close();
    }

    public static void deletePlayerPlaysDayByNumber(Player player, int dayNumber){
        PlayerPlaysDay pd = DayHelper.getTimeByPlayerAndDayNumber(player, (byte)dayNumber);
        DayHelper.deletePlayerPlaysDay(pd);
    }

    public static List<PlayerPlaysDay> getAllPlayersByDay(Day day){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        String hql = "from PlayerPlaysDay where day = :day";
        Query q = session.createQuery(hql);
        q.setParameter("day",day);
        List<PlayerPlaysDay> ppd;
        try{
            ppd = q.list();
        }catch (NoResultException ex){
            ppd=new ArrayList<PlayerPlaysDay>();
        }
        session.close();
        return ppd;
    }
}
