package org.example.packageTen;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageSix.Fish;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppTen {

    public static long create(Shop shop){
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(shop);
            session.getTransaction().commit();
            session.close();
            System.out.println("Shop added successfully");

        }catch(Exception e){
            e.getMessage();
        }
        return shop.getId();
    }

    public static List<Shop> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Shop> shop = session.createQuery("FROM Shop ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + shop.size() + " shop ");
        return shop;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Shop shop = (Shop) session.get(Shop.class, id);
        session.delete(shop);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Магазин успешно удалена");

    }

    public static void dropShopTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Shop ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Все магазины успешно удалены ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
