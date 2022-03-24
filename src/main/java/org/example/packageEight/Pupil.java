package org.example.packageEight;

import javax.persistence.*;

@Entity
@Table(name = "pupils")
public class Pupil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String course;
    private String country;

    public Pupil() {
    }

    public Pupil(String name, int age, String course, String country) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.country = country;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Ученики{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", возраст=" + age +
                ", урок='" + course + '\'' +
                ", страна='" + country + '\'' +
                '}';
    }
}
