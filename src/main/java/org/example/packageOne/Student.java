package org.example.packageOne;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "student_name")
    private String name;
    private String course;
    private int age;

    public Student() {
    }

    public Student(String name, String course, int age) {
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Студент{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", курс='" + course + '\'' +
                ", возраст=" + age +
                '}';
    }
}
