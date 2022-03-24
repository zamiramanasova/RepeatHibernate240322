package org.example.packageFour;

import javax.persistence.*;

@Entity
@Table(name = "trees")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String color;
    private int old;
    private String treeFamily;

    public Tree() {
    }

    public Tree(String name, String color, int old, String treeFamily) {
        this.name = name;
        this.color = color;
        this.old = old;
        this.treeFamily = treeFamily;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getTreeFamily() {
        return treeFamily;
    }

    public void setTreeFamily(String treeFamily) {
        this.treeFamily = treeFamily;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", цвет='" + color + '\'' +
                ", возраст=" + old +
                ", семейство='" + treeFamily + '\'' +
                '}';
    }
}
