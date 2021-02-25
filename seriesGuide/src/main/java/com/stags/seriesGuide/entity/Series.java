package com.stags.seriesGuide.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SERIES")
public class Series {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "genres")
    private String genres;

    @Column(name = "coverPicture")
    private String coverPicture;

    @Column(name = "releaseDate")
    private Date releaseDate;

    public long getId() {
        return id;
    }

    public Series setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Series setName(String name) {
        this.name = name;
        return this;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Series setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public String getGenres() {
        return genres;
    }

    public Series setGenres(String genres) {
        this.genres = genres;
        return this;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public Series setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
        return this;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Series setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }
}
