package com.stags.seriesGuide.entity;

import javax.persistence.*;

@Entity
@Table(name = "STATUS")
public class Status {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "status")
    private String status;

    @Column(name = "userId")
    private long userId;

    @Column(name = "seriesId")
    private long seriesId;

    public long getId() {
        return id;
    }

    public Status setId(long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Status setStatus(String status) {
        this.status = status;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Status setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public long getSeriesId() {
        return seriesId;
    }

    public Status setSeriesId(long seriesId) {
        this.seriesId = seriesId;
        return this;
    }
}
