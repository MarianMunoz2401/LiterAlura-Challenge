package com.AluraChallenge.LiterAlura.Repository;

import com.AluraChallenge.LiterAlura.BookDTO;
import com.AluraChallenge.LiterAlura.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Métodos personalizados para consultar libros
    long countByLanguage(String language);
    @Query("SELECT b FROM Book b ORDER BY b.downloadCount DESC")
    List<Book> findTop10BooksByDownloadCountDesc();
}
