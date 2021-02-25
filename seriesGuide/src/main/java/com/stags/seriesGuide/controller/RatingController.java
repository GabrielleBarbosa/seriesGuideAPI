package com.stags.seriesGuide.controller;

import com.stags.seriesGuide.entity.Rating;
import com.stags.seriesGuide.models.RatingRequest;
import com.stags.seriesGuide.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService service;

    @GetMapping("/ratings")
    public List<Rating> getRatings(){
        return service.getRatings();
    }

    @GetMapping("/ratings/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable long userId){
        return service.getRatingsByUserId(userId);
    }

    @PostMapping("/ratings")
    public Rating saveRating(@RequestBody RatingRequest rating){
        return service.saveRating(rating);
    }
}
