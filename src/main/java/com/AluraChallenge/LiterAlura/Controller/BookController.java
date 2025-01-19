package com.AluraChallenge.LiterAlura.Controller;

import com.AluraChallenge.LiterAlura.Dto.ApiResponse;
import com.AluraChallenge.LiterAlura.Services.HttpClientService;
import com.AluraChallenge.LiterAlura.Services.BookService;
import com.AluraChallenge.LiterAlura.Services.AuthorService;
import com.AluraChallenge.LiterAlura.Entity.Book;
import com.AluraChallenge.LiterAlura.Entity.Author;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final HttpClientService httpClientService;

    @Autowired
    public BookController(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // Endpoint para obtener libros desde la API de Gutendex
    @GetMapping("/books")
    public ResponseEntity<String> getBooks(@RequestParam String url) {
        try {
            // Realiza la solicitud a la API
            ApiResponse apiResponse = httpClientService.fetchBooks(url);

            // Convierte el ApiResponse a un String (puede ser a través de un método toString o serializando el objeto)
            String jsonResponse = convertApiResponseToJson(apiResponse);

            return ResponseEntity.ok(jsonResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los datos.");
        }
    }

    // Obtener los 10 libros más descargados
    @GetMapping("/top10books")
    public List<Book> getTop10Books() {
        return bookService.getTop10BooksByDownloadCount();
    }

    // Buscar autores por nombre
    @GetMapping("/searchAuthors")
    public List<Author> searchAuthors(@RequestParam String name) {
        return authorService.searchAuthorByName(name);
    }

    private String convertApiResponseToJson(ApiResponse apiResponse) {
        // Si estás usando una librería como Jackson o Gson, puedes convertir el objeto ApiResponse a JSON.
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(apiResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}"; // Retorna un JSON vacío en caso de error
        }
    }
}


