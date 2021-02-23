package com.stags.seriesGuide.entity;

import javax.persistence.*;

@Entity
@Table(name = "RATING")
public class Rating {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "score")
    private int score;

    @Column(name = "seriesId")
    private long seriesId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "userId")
    private long userId;

    public long getId() {
        return id;
    }

    public Rating setId(long id) {
        this.id = id;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Rating setScore(int score) {
        this.score = score;
        return this;
    }

    public long getSeriesId() {
        return seriesId;
    }

    public Rating setSeriesId(long seriesId) {
        this.seriesId = seriesId;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Rating setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Rating setUserId(long userId) {
        this.userId = userId;
        return this;
    }
}
