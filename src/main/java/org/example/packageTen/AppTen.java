package org.example.packageTen;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageSix.Fish;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppTen {
    public static void main(String[] args) {
        Util.getSessionFactory();

        Shop shop1 = new Shop("Milan", "Dior", "big",1967);
        Shop shop2 = new Shop("London", "Burberry", "big",1955);
        Shop shop3 = new Shop("Paris", "Nina Rici", "medium",1981);
        Shop shop4 = new Shop("Rim", "Tom Ford", "big",1949);
        Shop shop5 = new Shop("Madrid", "Carte", "big",1934);
        create(shop1);
        create(shop2);
        create(shop3);
        create(shop4);
        create(shop5);

        read();
        List<Shop> shops = read();
        for (Shop shop: shops) {
            System.out.println(shop);
        }

        deleteById(1);
        dropShopTable();

    }

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
