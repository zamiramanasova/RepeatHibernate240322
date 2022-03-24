package org.example.packageFive;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageOne.Student;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppFive {
    public static void main(String[] args) {
        Util.getSessionFactory();

        City city1 = new City("Paris","Evrazia", 21000000,486);
        City city2 = new City("London","Evrazia", 13000000,41);
        City city3 = new City("Moscow","Evrazia", 9000000,1141);
        City city4 = new City("Bishkek","Evrazia", 2000000,1825);
        City city5 = new City("Tashkent","Evrazia", 11000000,2400);
        create(city1);
        create(city2);
        create(city3);
        create(city4);
        create(city5);


        read();
        List<City> cities = read();
        for (City city: cities) {
            System.out.println(city);
        }

        deleteById(1);
        dropCitiesTable();

    }

    public static long create(City city) {
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
            session.close();
            System.out.println("City added successfully");

        } catch (Exception e) {
            e.getMessage();

        }return city.getId();
    }

    public static List<City> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<City> cities = session.createQuery("FROM City ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + cities.size() + " cities ");
        return cities;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        City city = (City) session.get(City.class, id);
        session.delete(city);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Город успешно удален");

    }

    public static void dropCitiesTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From City ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Успешное удаление всех городов");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
