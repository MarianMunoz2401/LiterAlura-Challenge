package com.AluraChallenge.LiterAlura;


import com.AluraChallenge.LiterAlura.config.DataSourceConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiClaseConDB {

    // Obtén el DataSource configurado
    private static HikariDataSource dataSource = DataSourceConfig.createDataSource();

    public static void main(String[] args) {
        // Intenta conectarte y realizar una consulta
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("¡Conexión exitosa!");

            // Ejemplo de consulta SQL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mi_tabla");

            // Iterar sobre los resultados
            while (resultSet.next()) {
                String columna1 = resultSet.getString("columna1");
                String columna2 = resultSet.getString("columna2");
                System.out.println("Columna1: " + columna1 + ", Columna2: " + columna2);
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos o ejecutar consulta:");
            e.printStackTrace();
        }
    }
}
