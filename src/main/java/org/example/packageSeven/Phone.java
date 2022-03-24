package org.example.packageSeven;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String model;
    private int price;
    private String madeIn;

    public Phone() {
    }

    public Phone(String name, String model, int price, String madeIn) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.madeIn = madeIn;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    @Override
    public String toString() {
        return "Телефон{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", модель='" + model + '\'' +
                ", цена=" + price +
                ", сделано в ='" + madeIn + '\'' +
                '}';
    }
}
