package com.AluraChallenge.LiterAlura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/LiterAlura";
        String user = "postgres"; // Cambia por tu usuario
        String password = "131001"; // Cambia por tu contraseña

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a la base de datos!");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
    }
}
