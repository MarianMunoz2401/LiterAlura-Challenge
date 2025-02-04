package com.AluraChallenge.LiterAlura.Dto;

import com.AluraChallenge.LiterAlura.BookDTO;

import java.util.List;

public class ApiResponse {
    private int count;
    private String next;
    private String previous;
    private List<BookDTO> results;

    // Getters y setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<BookDTO> getResults() {
        return results;
    }

    public void setResults(List<BookDTO> results) {
        this.results = results;
    }
}

