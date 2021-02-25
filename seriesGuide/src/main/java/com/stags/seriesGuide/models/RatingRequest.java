package com.stags.seriesGuide.models;

import com.stags.seriesGuide.entity.Rating;

import javax.persistence.Column;

public class RatingRequest {

    private long id;
    private int score;
    private long seriesId;
    private String comment;
    private long userId;

    public RatingRequest(long id, int score, long seriesId, String comment, long userId) {
        this.id = id;
        this.score = score;
        this.seriesId = seriesId;
        this.comment = comment;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public RatingRequest setId(long id) {
        this.id = id;
        return this;
    }

    public int getScore() {
        return score;
    }

    public RatingRequest setScore(int score) {
        this.score = score;
        return this;
    }

    public long getSeriesId() {
        return seriesId;
    }

    public RatingRequest setSeriesId(long seriesId) {
        this.seriesId = seriesId;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public RatingRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public RatingRequest setUserId(long userId) {
        this.userId = userId;
        return this;
    }
}
