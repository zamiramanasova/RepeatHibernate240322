package org.example.packageSix;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageSeven.Phone;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppSix {
    public static void main(String[] args) {
        Util.getSessionFactory();

        Fish fish1 = new Fish("Щука", "на речке", "50см", true);
        Fish fish2 = new Fish("Минтай", "на речке", "60см", false);
        Fish fish3 = new Fish("Акула", "море, океан", "5метров", true);
        Fish fish4 = new Fish("Форель", "на речке", "70см", false);
        Fish fish5 = new Fish("Кит", "море, океан", "33метра", false);
        create(fish1);
        create(fish2);
        create(fish3);
        create(fish4);
        create(fish5);

        read();
        List<Fish> fish = read();
        for (Fish f: fish) {
            System.out.println(f);
        }

        deleteById(1);
        dropFishTable();
    }

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
