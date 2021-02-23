package com.stags.seriesGuide.service;

import com.stags.seriesGuide.entity.Series;
import com.stags.seriesGuide.models.SeriesRequest;
import com.stags.seriesGuide.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository repository;

    public Series getSeriesById(long id){
        return repository.findById(id).orElse(null);
    }

    public List<Series> getSeries(){
        return repository.findAll();
    }

    public Series saveSeries(SeriesRequest series){
        Series s = new Series().setGenres(series.getGenres()).setId(series.getId()).setName(series.getName()).setSynopsis(series.getSynopsis()).setCoverPicture(series.getCoverPicture()).setReleaseDate(series.getReleaseDate());
        return repository.save(s);
    }

}
