package com.AluraChallenge.LiterAlura;

import com.AluraChallenge.LiterAlura.Entity.Author;


public class BookDTO {
    private String title;
    private Author author;  // Ahora usamos la entidad Author directamente

    public BookDTO(String title, Author author) {
        this.title = title;
        this.author = author;
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

    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + (author != null ? author.getName() : "Unknown");
    }
}



