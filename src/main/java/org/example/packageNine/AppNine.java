package org.example.packageNine;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageFive.City;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppNine {

    public static long create(Planet planet) {
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(planet);
            session.getTransaction().commit();
            session.close();
            System.out.println("Planet added successfully");
        } catch(Exception e) {
            e.getMessage();
        }return planet.getId();
    }

    public static List<Planet> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Planet> planets = session.createQuery("FROM Planet ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + planets.size() + " planet ");
        return planets;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.delete(planet);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Планета успешно удалена");

    }

    public static void dropPlanetTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Planet ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Успешное удаление всех планет");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
