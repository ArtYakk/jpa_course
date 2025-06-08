package com.artemyakkonen.advanced_mapping.entity.id;

import jakarta.persistence.Column;

import java.io.Serializable;

public class BookId implements Serializable {
    @Column(name = "author")
    private String author;

    @Column(name = "name")
    private String name;

    public BookId() {
    }

    public BookId(String author, String name) {
        this.author = author;
        this.name = name;
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
}
