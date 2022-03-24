package org.example.packageThree;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageTen.Shop;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppThree {
    public static void main(String[] args) {
        Util.getSessionFactory();

        Country country1 = new Country("Южная Америка", "Бразилия", 82000000, "Бразилиа" );
        Country country2 = new Country("Северная Америка", "Канада", 90000000, "Оттава" );
        Country country3 = new Country("Африка", "Марокко", 45000000, "Марокко" );
        Country country4 = new Country("Евразия", "Россия", 140000000, "Ьосква" );
        Country country5 = new Country("Австралия", "Австралия", 56000000, "Канберра" );
        create(country1);
        create(country2);
        create(country3);
        create(country4);
        create(country5);

        read();
        List<Country> countryList = read();
        for (Country country: countryList) {
            System.out.println(country);
        }

        deleteById(1);
        dropCountryTable();
    }

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
