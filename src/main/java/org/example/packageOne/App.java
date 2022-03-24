package org.example.packageOne;

import org.example.config.Util;
import org.example.packageEight.Pupil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Util.getSessionFactory();

        Student student1 = new Student("Meerim", "Java", 18);
        Student student2 = new Student("Vova", "Git", 18);
        Student student3 = new Student("Vadim", "Piton", 24);
        Student student4 = new Student("Maria", "CSS", 42);
        Student student5 = new Student("Denis", "PEGAS", 19);
        create(student1);
        create(student2);
        create(student3);
        create(student4);
        create(student5);

        read();
        List<Student> students = read();
        for (Student student: students) {
            System.out.println(student);
        }

        deleteById(1);
        dropStudentTable();
   }

    public static int create(Student student){
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Student save successfully : "+ student);
        return (int) student.getId();

    }

    public static List<Student> read() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("FROM Student ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("++++++++++++Finded " + students.size() + " student ");
        return students;
    }

    public static void deleteById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("#######################");
        System.out.println("Студент успешно удален");

    }

    public static void dropStudentTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("Delete From Student");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("#######################");
            System.out.println("Успешное удаление всех студентов");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
