package com.example.resortsoftheworldapplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resort_t")
public class Resort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_f", nullable = false, unique = true)
    private String name;

    @Column(name = "seawater_temperature_f")
    private Float seawaterTemperature;

    @Column(name = "air_temperature_f")
    private Float airTemperature;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Resort() {
        id = -1;
        name = null;
        seawaterTemperature = null;
        airTemperature = null;
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

    public Float getSeawaterTemperature() {
        return seawaterTemperature;
    }

    public void setSeawaterTemperature(Float seawaterTemperature) {
        this.seawaterTemperature = seawaterTemperature;
    }

    public Float getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(Float airTemperature) {
        this.airTemperature = airTemperature;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Resort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seawaterTemperature=" + seawaterTemperature +
                ", airTemperature=" + airTemperature +
                ", country=" + country +
                '}';
    }
}
