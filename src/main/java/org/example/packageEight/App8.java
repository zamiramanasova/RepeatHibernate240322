package org.example.packageEight;

import org.example.config.Util;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class App8 {

    public static long create(Pupil pupil){
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pupil);
            session.getTransaction().commit();
            session.close();
            System.out.println("Pupil added successfully");
        }catch(Exception e){
            e.getMessage();
        }
        return pupil.getId();
    }

    public static List<Pupil> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Pupil> pupils = session.createQuery("FROM Pupil ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + pupils.size() + " pupils ");
        return pupils;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Pupil pupil = (Pupil) session.get(Pupil.class, id);
        session.delete(pupil);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Ученик успешно удален");

    }

    public static void dropPupilsTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Pupil ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Успешное удаление всех учеников");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
