package com.stags.seriesGuide.service;

import com.stags.seriesGuide.entity.Rating;
import com.stags.seriesGuide.models.RatingRequest;
import com.stags.seriesGuide.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository repository;

    public List<Rating> getRatings(){
        return repository.findAll();
    }

    public List<Rating> getRatingsByUserId(long userId){
        return repository.findByUserId(userId);
    }

    public Rating saveRating(RatingRequest rating){
        Rating r = new Rating().setId(rating.getId())
                .setComment(rating.getComment())
                .setScore(rating.getScore())
                .setSeriesId(rating.getSeriesId())
                .setUserId(rating.getUserId());
        return repository.save(r);
    }

}
