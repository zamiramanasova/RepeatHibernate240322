package org.example.packageEight;

import org.example.config.Util;
import org.example.packageOne.Student;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class App8 {

    public static void main(String[] args) {

         Util.getSessionFactory();

        Pupil pupil1 = new Pupil("Masha", 15, "Russian language", "Russia");
        Pupil pupil2 = new Pupil("Burul", 15, "Kyrgyz language", "Kyrgyzstan");
        Pupil pupil3 = new Pupil("Meerim", 15, "Yzbek language", "Russia");
        Pupil pupil4 = new Pupil("Boris", 15, "English language", "Belorusia");
        Pupil pupil5 = new Pupil("Volodya", 15, "Kazah language", "Kazahstan");
        create(pupil1);
        create(pupil2);
        create(pupil3);
        create(pupil4);
        create(pupil5);

        read();
        List<Pupil> pupils = read();
        for (Pupil pupil: pupils) {
            System.out.println(pupil);
        }

        deleteById(1);
        dropPupilsTable();

    }

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
