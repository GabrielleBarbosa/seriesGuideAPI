package com.stags.seriesGuide.models;

import com.stags.seriesGuide.entity.Series;
import java.util.Date;

public class SeriesRequest {

    private long id;
    private String name;
    private String synopsis;
    private String genres;
    private String coverPicture;
    private Date releaseDate;

    public SeriesRequest(long id, String name, String synopsis, String genres, String coverPicture, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.synopsis = synopsis;
        this.genres = genres;
        this.coverPicture = coverPicture;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
