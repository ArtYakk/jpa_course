package com.artemyakkonen.advanced_mapping.entity;


import com.artemyakkonen.advanced_mapping.entity.id.BookId;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "books")
@IdClass(BookId.class)
public class Book {


    @Id
    @Column(name = "author")
    private String author;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "rating")
    private Double rating;

    public Book() {
    }

    public Book(String author, String name, Integer publicationYear, Double rating) {
        this.author = author;
        this.name = name;
        this.publicationYear = publicationYear;
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", rating=" + rating +
                '}';
    }
}
