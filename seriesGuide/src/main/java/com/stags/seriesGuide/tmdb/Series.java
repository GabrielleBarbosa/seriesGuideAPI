package com.stags.seriesGuide.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {

    private long id;
    private Date first_air_date;
    private List<Genre> genres;
    private String name;
    private int number_of_seasons;
    private String overview;
    private String poster_path;
    private String status;
    private float vote_average;
    private int vote_count;
    private String original_name;

    public Series(long id, Date first_air_date, List<Genre> genres, String name, int number_of_seasons, String overview, String poster_path, String status, float vote_average, int vote_count, String original_name) {
        this.id = id;
        this.first_air_date = first_air_date;
        this.genres = genres;
        this.name = name;
        this.number_of_seasons = number_of_seasons;
        this.overview = overview;
        this.poster_path = poster_path;
        this.status = status;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.original_name = original_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(Date first_air_date) {
        this.first_air_date = first_air_date;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(int number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }
}
