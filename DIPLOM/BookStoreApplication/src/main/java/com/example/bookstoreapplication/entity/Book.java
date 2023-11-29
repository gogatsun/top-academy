package com.example.bookstoreapplication.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book_t")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID книги

    @Column(name = "title_f", length = 150, nullable = false)
    private String title; // название

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author; // автор

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher; // издательство

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    private Series series; // книжная серия

    @Column(name = "price_f", nullable = false)
    private Integer price; // цена

    @Column(name = "publication_date_f")
    private Date publicationDate; // год издания

    @Column(name = "isbn_f", length = 13, nullable = false)
    private String isbn; // ISBN - международный стандартный книжный номер

    @Column(name = "page_count_f")
    private Integer pageCount; // кол-во страниц

    @ManyToOne
    @JoinColumn(name = "cover_type_id", nullable = false)
    private CoverType coverType; // тип обложки

    @Column(name = "edition_f", nullable = false)
    private Integer edition; // тираж

    @Column(name = "weight_f")
    private Integer weight; // вес, г.

    @ManyToOne
    @JoinColumn(name = "age_limit_id", nullable = false)
    private AgeLimit ageLimit; // возрастное ограничение

    @Column(name = "quantity_f", nullable = false)
    private Integer quantity; // количество на складе

    public Book() {
        id = null;
        title = "Default constructor";
        price = null;
        publicationDate = null;
        isbn = "Default constructor";
        pageCount = null;
        edition = null;
        weight = null;
        ageLimit = null;
        quantity = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", series=" + series +
                ", price=" + price +
                ", publicationDate=" + publicationDate +
                ", isbn='" + isbn + '\'' +
                ", pageCount=" + pageCount +
                ", coverType=" + coverType +
                ", edition=" + edition +
                ", weight=" + weight +
                ", ageLimit=" + ageLimit +
                ", quantity=" + quantity +
                '}';
    }
}
