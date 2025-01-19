package com.AluraChallenge.LiterAlura.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único para el autor
    private String name;
    private LocalDate birthDate;  // Fecha de nacimiento
    private LocalDate deathDate;  // Fecha de fallecimiento (si corresponde)

    // Constructor vacío para JPA
    public Author() {}

    // Constructor con parámetros
    public Author(String name, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathYear(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    // Método para obtener el año de nacimiento
    public int getBirthYear() {
        return birthDate != null ? birthDate.getYear() : 0;  // Retorna 0 si birthDate es null
    }

    // Método para obtener el año de fallecimiento
    public int getDeathYear() {
        return deathDate != null ? deathDate.getYear() : 0;  // Retorna 0 si deathDate es null
    }
}


