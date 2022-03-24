package org.example.packageFour;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.example.packageFive.City;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppFour {
    public static void main(String[] args) {

        Util.getSessionFactory();

        Tree tree1 = new Tree("Дуб", "зеленый", 1500, "Буковые");
        Tree tree2 = new Tree("Береза", "бело-зеленая", 120, "Березовые");
        Tree tree3 = new Tree("Клен", "ярко-зеленый", 250, "Сапиндовые");
        Tree tree4 = new Tree("Орех", "зеленый", 350, "Ореховые");
        Tree tree5 = new Tree("Самшит", "ярко-зеленый", 500, "Самшитовые");
        create(tree1);
        create(tree2);
        create(tree3);
        create(tree4);
        create(tree5);

        read();
        List<Tree> trees = read();
        for (Tree tree: trees) {
            System.out.println(tree);
        }

        deleteById(1);
        dropTreeTable();
    }

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
