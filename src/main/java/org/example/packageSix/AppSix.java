package org.example.packageSix;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageSeven.Phone;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppSix {

    public static long create(Fish fish){
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(fish);
            session.getTransaction().commit();
            session.close();
            System.out.println("Fish added successfully");
        }catch(Exception e){
            e.getMessage();
        }
        return fish.getId();
    }

    public static List<Fish> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Fish> fish = session.createQuery("FROM Fish ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + fish.size() + " fish ");
        return fish;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Fish fish = (Fish) session.get(Fish.class, id);
        session.delete(fish);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Рыба успешно удалена");

    }

    public static void dropFishTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Fish ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Успешное удаление всех рыб");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
