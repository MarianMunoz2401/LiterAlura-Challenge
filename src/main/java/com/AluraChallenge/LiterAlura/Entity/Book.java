package com.AluraChallenge.LiterAlura.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único para el libro
    private String title;
    private String language; // Idioma del libro

    @ManyToOne
    private Author author;  // Relación con la entidad Author

    private Long downloadCount;  // Contador de descargas

    // Constructor vacío para JPA
    public Book() {}

    // Constructor con parámetros
    public Book(String title, String language, Author author) {
        this.title = title;
        this.author = author;
        this.language = language;
    }

    // Getters y setters
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    // Representación como cadena (para impresión)
    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + (author != null ? author.getName() : "Unknown");
    }
}



