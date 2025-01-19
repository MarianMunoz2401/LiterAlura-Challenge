package com.AluraChallenge.LiterAlura;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JsonToJavaExample {

    public static void main(String[] args) {
        String jsonResponse = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"Java Programming\",\n" +
                "  \"author\": \"John Doe\",\n" +
                "  \"publish_year\": 2021,\n" +
                "  \"isbn\": \"123-456-789\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convertir el JSON a una instancia de Book
            BookDTO book = objectMapper.readValue(jsonResponse, BookDTO.class);

            // Mostrar los detalles del libro
            System.out.println(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
