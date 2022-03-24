package org.example.packageThree;

import org.example.config.Util;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppThree {

    public static long create(Country country){
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
            session.close();
            System.out.println("Country added successfully");

        }catch(Exception e){
            e.getMessage();
        }
        return country.getId();
    }

    public static List<Country> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Country> country = session.createQuery("FROM Country ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + country.size() + " country ");
        return country;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = (Country) session.get(Country.class, id);
        session.delete(country);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Страна успешно удалена");

    }

    public static void dropCountryTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Country ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Все страны успешно удалены ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
