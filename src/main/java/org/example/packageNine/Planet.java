package org.example.packageNine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private boolean lifeOnThePlanet;
    private String square;
    private int yearOfOpening;

    public Planet() {
    }

    public Planet(String name, boolean lifeOnThePlanet, String square, int yearOfOpening) {
        this.name = name;
        this.lifeOnThePlanet = lifeOnThePlanet;
        this.square = square;
        this.yearOfOpening = yearOfOpening;
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

    public boolean isLifeOnThePlanet() {
        return lifeOnThePlanet;
    }

    public void setLifeOnThePlanet(boolean lifeOnThePlanet) {
        this.lifeOnThePlanet = lifeOnThePlanet;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public int getYearOfOpening() {
        return yearOfOpening;
    }

    public void setYearOfOpening(int yearOfOpening) {
        this.yearOfOpening = yearOfOpening;
    }

    @Override
    public String toString() {
        return "Планета{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", жизнь на планете=" + lifeOnThePlanet +
                ", площадь=" + square +
                ", год открытия=" + yearOfOpening +
                '}';
    }
}
