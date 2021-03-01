package com.stags.seriesGuide.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeriesSearch {
    private List<SeriesSearchResult> results;
    private int total_pages;

    public SeriesSearch(){};

    public SeriesSearch(List<SeriesSearchResult> results, int total_pages) {
        this.results = results;
        this.total_pages = total_pages;
    }

    public List<SeriesSearchResult> getResults() {
        return results;
    }

    public void setResults(List<SeriesSearchResult> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
