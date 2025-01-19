package com.AluraChallenge.LiterAlura.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.AluraChallenge.LiterAlura.Dto.ApiResponse;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HttpClientService {

    public ApiResponse fetchBooks(String url) throws IOException, InterruptedException {
        // Código para hacer la solicitud HTTP a la API de Gutendex
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Aquí suponemos que ApiResponse es un objeto que puede deserializarse desde JSON
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body(), ApiResponse.class);
    }
}

