package com.stags.seriesGuide.models;

public class StatusRequest {
    private long id;
    private String status;
    private long userId;
    private long seriesId;

    public StatusRequest(long id, String status, long userId, long seriesId) {
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.seriesId = seriesId;
    }

    public long getId() {
        return id;
    }

    public StatusRequest setId(long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StatusRequest setStatus(String status) {
        this.status = status;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public StatusRequest setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public long getSeriesId() {
        return seriesId;
    }

    public StatusRequest setSeriesId(long seriesId) {
        this.seriesId = seriesId;
        return this;
    }
}
