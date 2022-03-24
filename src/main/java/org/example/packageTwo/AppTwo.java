package org.example.packageTwo;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageThree.Country;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppTwo {

    public static long create(Continent continent){
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(continent);
            session.getTransaction().commit();
            session.close();
            System.out.println("Continent added successfully");

        }catch(Exception e){
            e.getMessage();
        }
        return continent.getId();
    }

    public static List<Continent> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Continent> continent = session.createQuery("FROM Continent ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + continent.size() + " continent");
        return continent;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Continent continent = (Continent) session.get(Continent.class, id);
        session.delete(continent);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Континент успешно удален");

    }

    public static void dropContinentTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Continent ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Все континенты успешно удалены ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
