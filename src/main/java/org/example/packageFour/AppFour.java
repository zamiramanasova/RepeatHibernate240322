package org.example.packageFour;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageFive.City;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppFour {

    public static long create(Tree tree) {
        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tree);
            session.getTransaction().commit();
            session.close();
            System.out.println("Tree added successfully");

        } catch (Exception e) {
            e.getMessage();

        }return tree.getId();
    }

    public static List<Tree> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Tree> tree = session.createQuery("FROM Tree ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + tree.size() + " tree ");
        return tree;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Tree tree = (Tree) session.get(Tree.class, id);
        session.delete(tree);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Дерево успешно удалено");

    }

    public static void dropTreeTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Tree ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Успешное удаление всех деревьев");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
