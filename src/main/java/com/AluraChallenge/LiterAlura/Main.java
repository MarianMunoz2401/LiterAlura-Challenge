package com.AluraChallenge.LiterAlura;

import com.AluraChallenge.LiterAlura.Entity.Author;
import com.AluraChallenge.LiterAlura.Repository.AuthorRepository;
import com.AluraChallenge.LiterAlura.Repository.BookRepository;
import com.AluraChallenge.LiterAlura.Utils.GutendexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main implements CommandLineRunner {

    // Instancia de Scanner para leer entradas del usuario
    private final Scanner scanner = new Scanner(System.in);

    // Lista para almacenar los libros consultados
    private final List<BookDTO> books = new ArrayList<>();
    private final List<Author> authors = new ArrayList<>();

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Llamamos al método para mostrar el menú interactivo
        displayMenu();
    }

    // Método para mostrar el menú de opciones al usuario
    private void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("Select an option:");
            System.out.println("1 - Search book by title");
            System.out.println("2 - View all books");
            System.out.println("3 - List authors");
            System.out.println("4 - List authors alive in a certain year");
            System.out.println("5 - Exit");

            // Capturar la opción del usuario
            int option = getOption();

            switch (option) {
                case 1:
                    searchBookByTitle();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    listAuthors();
                    break;
                case 4:
                    listAuthorsAliveInYear();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please select again.");
            }
        }
    }

    // Método para obtener una opción válida del usuario
    private int getOption() {
        int option = -1;
        boolean validOption = false;

        while (!validOption) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option < 1 || option > 3) {
                    throw new NumberFormatException();
                }
                validOption = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }
        return option;
    }

    // Método para buscar un libro por título en la API de Gutendex
    private void searchBookByTitle() {
        System.out.println("Enter the book title to search:");
        String title = scanner.nextLine();

        // Crear la URL de búsqueda con el título del libro
        String url = "https://gutendex.com/books/?search=" + title + "&languages=es"; // Usamos "es" para buscar en español

        // Usamos RestTemplate para hacer la solicitud a la API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        try {
            // Convertir la respuesta JSON a una lista de objetos Book
            ObjectMapper objectMapper = new ObjectMapper();
            GutendexResponse gutendexResponse = objectMapper.readValue(response.getBody(), GutendexResponse.class);

            if (gutendexResponse.getCount() > 0) {
                // Solo tomamos el primer libro de los resultados
                BookDTO book = gutendexResponse.getResults().get(0);
                books.add(book);  // Agregamos el libro a la lista
                System.out.println("Book found: " + book);

                // Agregar el autor a la lista de autores (si aún no está)
                Author author = book.getAuthor();  // Llamamos a getAuthor()
                if (author != null && !authors.contains(author)) {
                    authors.add(author);  // Agregamos el autor si no está en la lista
                    System.out.println("Author found: " + author.getName());
                    System.out.println("Born in: " + author.getBirthYear());
                    if (author.getDeathYear() != 0) {
                        System.out.println("Died in: " + author.getDeathYear());
                    }
                }
            } else {
                System.out.println("No books found for the title: " + title);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while processing the book search.");
        }
    }


    // Método para ver todos los libros consultados
    private void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books have been searched yet.");
        } else {
            System.out.println("Books searched so far:");
            for (BookDTO book : books) {
                System.out.println(book);
            }
        }
    }
    private void listAuthors() {
        if (authors.isEmpty()) {
            System.out.println("No authors have been added yet.");
        } else {
            System.out.println("Authors of the books searched so far:");
            for (Author author : authors) {
                System.out.println("Author: " + author.getName());
                // Obtener el año de nacimiento y mostrarlo
                System.out.println("Born in: " + author.getBirthYear());
                // Si tienes el año de fallecimiento también, lo puedes mostrar
                if (author.getDeathYear() != 0) {
                    System.out.println("Died in: " + author.getDeathYear());
                }
                System.out.println("---");
            }
        }
    }


    private void listAuthorsAliveInYear() {
        System.out.println("Enter the year to check for living authors:");
        int year = Integer.parseInt(scanner.nextLine());

        boolean foundAliveAuthors = false;

        for (Author author : authors) {
            if (author.getBirthYear() <= year && (author.getDeathYear() == 0 || author.getDeathYear() >= year)) {
                System.out.println(author);
                foundAliveAuthors = true;
            }
        }

        if (!foundAliveAuthors) {
            System.out.println("No authors were alive in the year " + year);
        }
    }
}

