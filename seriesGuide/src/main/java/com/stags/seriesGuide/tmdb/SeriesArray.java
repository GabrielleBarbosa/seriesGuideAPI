package com.stags.seriesGuide.tmdb;

import java.util.List;

public class SeriesArray {
    private int total_pages;
    private List<Series> results;

    public SeriesArray(){};

    public SeriesArray(int total_pages, List<Series> results) {
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Series> getResults() {
        return results;
    }

    public void setResults(List<Series> results) {
        this.results = results;
    }
}
