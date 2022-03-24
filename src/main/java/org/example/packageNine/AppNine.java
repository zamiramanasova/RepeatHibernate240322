package org.example.packageNine;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageFive.City;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppNine {
    public static void main(String[] args) {

        Util.getSessionFactory();

        Planet planet1 = new Planet("Earth", true, "510072000 км²",1);
        Planet planet2 = new Planet("Mars", false, "144 млн км²",1543);
        Planet planet3 = new Planet("Neptune", false, "7,6408 миллиарда км²",1846);
        Planet planet4 = new Planet("Venus", false, "460 234 317 км²",1610);
        Planet planet5 = new Planet("Mercury", false, "74 797 000 км²",1781);
        create(planet1);
        create(planet2);
        create(planet3);
        create(planet4);
        create(planet5);

        read();
        List<Planet> planets = read();
        for (Planet planet: planets) {
            System.out.println(planet);
        }

        deleteById(1);
        dropPlanetTable();

    }

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
        Planet planet = (Planet) session.get(Planet.class, id);
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
