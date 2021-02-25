package com.stags.seriesGuide.controller;

import com.stags.seriesGuide.entity.Series;
import com.stags.seriesGuide.models.SeriesRequest;
import com.stags.seriesGuide.service.SeriesService;
import com.stags.seriesGuide.service.UserService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeriesController {

    @Autowired
    private SeriesService service;

   /* @GetMapping("/series")
    public List<Series> getSeries(){
        return service.getSeries();
    }

    @GetMapping("/series/{id}")
    public Series getSeriesById(@PathVariable long id){
        return service.getSeriesById(id);
    }

    @PostMapping("/series")
    public Series saveSeries(@RequestBody SeriesRequest series){
        return service.saveSeries(series);
    }*/
}
