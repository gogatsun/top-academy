package com.example.bookstoreapplication.entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "author_t")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID автора

    @Column(name = "surname_f", nullable = false)
    private String surname; // фамилия

    @Column(name = "name_f", nullable = false)
    private String name; // имя

    @Column(name = "patronymic_f", nullable = false)
    private String patronymic; // отчество

    @OneToMany(mappedBy = "author")
    private Set<Book> book;

    public Author() {
        id = null;
        surname = "";
        name = "";
        patronymic = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", book=" + book +
                '}';
    }
}
