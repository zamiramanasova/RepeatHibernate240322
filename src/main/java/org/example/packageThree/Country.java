package org.example.packageThree;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String continent;
    private String name;
    private int people;
    private String capital;

    public Country() {
    }

    public Country(String continent, String name, int people, String capital) {
        this.continent = continent;
        this.name = name;
        this.people = people;
        this.capital = capital;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Страна{" +
                "id=" + id +
                ", континент='" + continent + '\'' +
                ", имя='" + name + '\'' +
                ", население=" + people +
                ", столица='" + capital + '\'' +
                '}';
    }
}
