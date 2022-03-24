package org.example.packageTen;

import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String name;
    private String sizeShop;
    private int year;

    public Shop() {
    }

    public Shop(String city, String name, String sizeShop, int year) {
        this.city = city;
        this.name = name;
        this.sizeShop = sizeShop;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSizeShop() {
        return sizeShop;
    }

    public void setSizeShop(String sizeShop) {
        this.sizeShop = sizeShop;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Магазин{" +
                "id=" + id +
                ", город='" + city + '\'' +
                ", имя='" + name + '\'' +
                ", размер магазина='" + sizeShop + '\'' +
                ", год открытия=" + year +
                '}';
    }
}

