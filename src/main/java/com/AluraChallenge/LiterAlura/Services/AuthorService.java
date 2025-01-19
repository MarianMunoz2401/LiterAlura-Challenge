package com.AluraChallenge.LiterAlura.Services;

import com.AluraChallenge.LiterAlura.Entity.Author;
import com.AluraChallenge.LiterAlura.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAuthorsAliveInYear(int year) {
        LocalDate startOfYear = LocalDate.of(year, 1, 1);
        LocalDate endOfYear = LocalDate.of(year, 12, 31);

        return authorRepository.findByBirthDateBeforeAndDeathDateAfterOrDeathDateNull(startOfYear, endOfYear);
    }

    public List<Author> searchAuthorByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }
}

