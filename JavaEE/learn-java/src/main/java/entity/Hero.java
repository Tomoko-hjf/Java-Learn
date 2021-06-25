package entity;

import annotation.myhibernate.*;

import java.io.Serializable;

@MyEntity
@MyTable(name = "hero_")
public class Hero implements Serializable {
    private int id;
    private String name;
    private int damage;
    private int armor;

    @MyId
    @MyGeneratedValue(strategy = "identity")
    @MyColumn("id_")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @MyColumn(value = "name_")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MyColumn(value = "damage_")
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @MyColumn(value = "armor_")
    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero() {}

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", armor=" + armor +
                '}';
    }
}
