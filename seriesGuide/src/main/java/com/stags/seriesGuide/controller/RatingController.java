package com.stags.seriesGuide.controller;

import com.stags.seriesGuide.entity.Rating;
import com.stags.seriesGuide.models.RatingRequest;
import com.stags.seriesGuide.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

    @GetMapping("/userId/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable long userId){
        return service.getRatingsByUserId(userId);
    }

    @GetMapping("/seriesId/{seriesId}")
    public List<Rating> getRatingsBySeriesId(@PathVariable long seriesId){
        return service.getRatingsBySeriesId(seriesId);
    }

    @PostMapping()
    public Rating saveRating(@RequestBody RatingRequest rating){
        return service.saveRating(rating);
    }

    @PutMapping()
    public Rating updateRating(@RequestBody RatingRequest rating){
        return service.saveRating(rating);
    }

    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable long id){
        return service.getRatingById(id);
    }
}
