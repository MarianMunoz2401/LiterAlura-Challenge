package com.AluraChallenge.LiterAlura.Repository;

import com.AluraChallenge.LiterAlura.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Derived query para encontrar autores vivos en un año determinado
    List<Author> findByBirthDateBeforeAndDeathDateAfterOrDeathDateNull(LocalDate yearStart, LocalDate yearEnd);
    // Buscar autores por nombre
    List<Author> findByNameContainingIgnoreCase(String name);
}
