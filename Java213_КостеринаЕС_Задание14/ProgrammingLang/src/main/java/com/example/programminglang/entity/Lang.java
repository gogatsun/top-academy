package com.example.programminglang.entity;

public class Lang {
    private Integer id;
    private String name;
    private Integer year;
    private String paradigm;
    private String level;

    public Lang() {
    }

    public Lang(Integer id, String name, Integer year, String paradigm, String level) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.paradigm = paradigm;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getParadigm() {
        return paradigm;
    }

    public void setParadigm(String paradigm) {
        this.paradigm = paradigm;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("ID: %d NAME: %s, YEAR: %s, PARADIGM: %s, LEVEL: %s",
                id, name, year, paradigm, level);
    }

}
