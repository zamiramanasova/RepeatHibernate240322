package org.example.packageSeven;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageNine.Planet;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppSeven {

    public static long create(Phone phone){
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(phone);
            session.getTransaction().commit();
            session.close();
            System.out.println("Phone added successfully");

        }catch(Exception e) {
            e.getMessage();
        }
        return phone.getId();
    }

    public static List<Phone> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Phone> phones = session.createQuery("FROM Phone ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + phones.size() + " phone ");
        return phones;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Phone phone = (Phone) session.get(Phone.class, id);
        session.delete(phone);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Телефон успешно удален");

    }

    public static void dropPhoneTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Phone ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Успешное удаление всех телефонов");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
