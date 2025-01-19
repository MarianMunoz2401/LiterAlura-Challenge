package com.AluraChallenge.LiterAlura.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceConfig {

    public static HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/LiterAlura"); // Reemplaza con tu base de datos
        config.setUsername("postgres"); // Reemplaza con tu usuario
        config.setPassword("131001"); // Reemplaza con tu contraseña

        // Configuración adicional
        config.setMaximumPoolSize(10);    // Máximo de conexiones en el pool
        config.setMinimumIdle(5);         // Conexiones inactivas mínimas
        config.setIdleTimeout(30000);     // 30 segundos para desconectar conexiones inactivas
        config.setConnectionTimeout(30000); // 30 segundos para obtener una conexión
        config.setMaxLifetime(1800000);    // 30 minutos para la vida máxima de una conexión

        // Si deseas controlar las transacciones manualmente, usa el siguiente:
        config.setAutoCommit(false);  // Desactivar autocommit si manejas transacciones

        return new HikariDataSource(config); // Retorna la fuente de datos configurada
    }
}
