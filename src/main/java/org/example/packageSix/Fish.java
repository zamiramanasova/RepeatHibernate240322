package org.example.packageSix;

import javax.persistence.*;

@Entity
@Table(name = "fish")
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String placeOfLife;
    private String size;
    private boolean predatorOrNot;

    public Fish() {
    }

    public Fish(String name, String placeOfLife, String size, boolean predatorOrNot) {
        this.name = name;
        this.placeOfLife = placeOfLife;
        this.size = size;
        this.predatorOrNot = predatorOrNot;
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

    public String getPlaceOfLife() {
        return placeOfLife;
    }

    public void setPlaceOfLife(String placeOfLife) {
        this.placeOfLife = placeOfLife;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isPredatorOrNot() {
        return predatorOrNot;
    }

    public void setPredatorOrNot(boolean predatorOrNot) {
        this.predatorOrNot = predatorOrNot;
    }

    @Override
    public String toString() {
        return "Рыба{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", место обитания='" + placeOfLife + '\'' +
                ", размер=" + size +
                ", хищник??=" + predatorOrNot +
                '}';
    }
}
