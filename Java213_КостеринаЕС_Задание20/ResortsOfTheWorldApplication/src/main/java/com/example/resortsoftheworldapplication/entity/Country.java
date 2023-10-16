package com.example.resortsoftheworldapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "country_t")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_f", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private Set<Resort> resort;

    public Country() {
        id = -1;
        name = null;
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

    public Set<Resort> getResort() {
        return resort;
    }

    public void setResort(Set<Resort> resort) {
        this.resort = resort;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resort=" + resort +
                '}';
    }
}
