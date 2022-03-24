package org.example.packageFive;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String continent;
    private int population;
    private int yearOfFoundation;

    public City() {
    }

    public City(String name, String continent, int population, int yearOfFoundation) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.yearOfFoundation = yearOfFoundation;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    @Override
    public String toString() {
        return "Город{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", континет='" + continent + '\'' +
                ", население=" + population +
                ", год создания=" + yearOfFoundation +
                '}';
    }
}
