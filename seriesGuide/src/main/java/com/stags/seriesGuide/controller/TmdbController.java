package com.stags.seriesGuide.controller;

import com.stags.seriesGuide.service.TmdbService;
import com.stags.seriesGuide.tmdb.Series;
import com.stags.seriesGuide.tmdb.SeriesArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TmdbController {

    @Autowired
    private TmdbService service;

    @GetMapping("/series/search")
    public SeriesArray getSeriesByQuery(@RequestParam String query, @RequestParam int page){
        return service.searchSeriesByQuery(query, page);
    }

    @GetMapping("/series/{id}")
    public Series getSeriesById(@PathVariable long id){
        return service.getSeriesById(id);
    }

    @GetMapping("/series/popular/{page}")
    public SeriesArray getPopularSeries(@PathVariable int page){
        return service.getPopularSeries(page);
    }

}
