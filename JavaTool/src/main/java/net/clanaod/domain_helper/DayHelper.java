package net.clanaod.domain_helper;

import net.clanaod.domain.Day;
import net.clanaod.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
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

    private static void addDay(String dayName){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Day day = new Day();
        day.setWeekday(dayName);
        session.saveOrUpdate(day);
        session.getTransaction().commit();
        session.close();
    }

    public static void importDay(String dayName){
        if(getDayByName(dayName) == null){
            addDay(dayName);
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
}
