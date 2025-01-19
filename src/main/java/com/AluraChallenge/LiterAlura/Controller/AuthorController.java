package com.AluraChallenge.LiterAlura.Controller;

import com.AluraChallenge.LiterAlura.Entity.Author;
import com.AluraChallenge.LiterAlura.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/alive-in-year")
    public List<Author> getAuthorsAliveInYear(@RequestParam int year) {
        // Verifica si el año ingresado es válido
        if (year <= 0) {
            throw new IllegalArgumentException("El año debe ser un valor positivo.");
        }

        return authorService.findAuthorsAliveInYear(year);
    }
}
