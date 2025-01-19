package com.AluraChallenge.LiterAlura.Utils;

import com.AluraChallenge.LiterAlura.BookDTO;

import java.util.List;

public class GutendexResponse {
    private int count;
    private List<BookDTO> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BookDTO> getResults() {
        return results;
    }

    public void setResults(List<BookDTO> results) {
        this.results = results;
    }
}
