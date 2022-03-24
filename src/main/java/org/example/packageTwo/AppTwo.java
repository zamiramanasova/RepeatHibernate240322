package org.example.packageTwo;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageThree.Country;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppTwo {
    public static void main(String[] args) {
        Util.getSessionFactory();

       Continent continent1 = new Continent("Africa", 60, "29,2 млн км²",1275920972);
       Continent continent2 = new Continent("Australia", 1, "7 692 024 км²",25726900);
       Continent continent3 = new Continent("South America", 12, "17 840 000 км²",385742554);
       Continent continent4 = new Continent("North America", 23, "24 709 000 км²",579000000);
       Continent continent5 = new Continent("Eurasia", 99, "55 000 000 км²", 5348554000L);
       create(continent1);
       create(continent2);
       create(continent3);
       create(continent4);
       create(continent5);

        read();
        List<Continent> continents = read();
        for (Continent continent: continents) {
            System.out.println(continent);
        }

        deleteById(1);
        dropContinentTable();
    }


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
