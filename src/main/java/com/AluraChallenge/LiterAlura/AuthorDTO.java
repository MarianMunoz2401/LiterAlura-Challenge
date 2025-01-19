package com.AluraChallenge.LiterAlura;

public class AuthorDTO {
    private String name;
    private int birthYear;
    private int deathYear;

    // Constructor, getters y setters...
    @Override
    public String toString() {
        return name + " (Born: " + birthYear + ", Died: " + (deathYear != 0 ? deathYear : "Alive") + ")";
    }
}



