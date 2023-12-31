package org.top.dbdriverexp.entity;

public class Student {
    private String name;
    private String city;
    private int id;

    public Student(String name, String city, int id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //toString
    @Override
    public String toString() {
        return id + ": " + name + " из " + city;
    }
}
