package com.AluraChallenge.LiterAlura.Services;

import com.AluraChallenge.LiterAlura.Repository.BookRepository;
import com.AluraChallenge.LiterAlura.Entity.Book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Obtener los 10 libros más descargados
    public List<Book> getTop10BooksByDownloadCount() {
        return bookRepository.findTop10BooksByDownloadCountDesc(); // Aquí se usa correctamente el repositorio
    }
}

