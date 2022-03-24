package org.example.packageTwo;

import javax.persistence.*;

@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int countCountries;
    private String square;
    private long population;

    public Continent() {
    }

    public Continent(String name, int countCountries, String square, long population) {
        this.name = name;
        this.countCountries = countCountries;
        this.square = square;
        this.population = population;
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

    public int getCountCountries() {
        return countCountries;
    }

    public void setCountCountries(int countCountries) {
        this.countCountries = countCountries;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Континент{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", колич, стран=" + countCountries +
                ", площадь=" + square +
                ", население=" + population +
                '}';
    }
}
