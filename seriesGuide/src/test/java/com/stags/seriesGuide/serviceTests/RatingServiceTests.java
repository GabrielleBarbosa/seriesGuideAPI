package com.stags.seriesGuide.serviceTests;

import com.stags.seriesGuide.entity.Rating;
import com.stags.seriesGuide.models.RatingRequest;
import com.stags.seriesGuide.repository.RatingRepository;
import com.stags.seriesGuide.service.RatingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RatingServiceTests {

    @Mock
    private RatingRepository repository;

    @InjectMocks
    private RatingService service;

    @Test
    public void shouldReturnCreatedRating(){
        RatingRequest ratingRequest = new RatingRequest(1, 1, 1, "", 1);
        when(repository.save(any(Rating.class))).thenReturn(new Rating().setUserId(ratingRequest.getUserId()));
        Rating created = service.saveRating(ratingRequest);
        assertEquals(ratingRequest.getUserId(), created.getUserId());
    }

    @Test
    public void shouldReturnRatingBySeriesId(){
        when(repository.findBySeriesId(any(Long.class))).thenReturn(Arrays.asList(new Rating()));
        List<Rating> response = service.getRatingsBySeriesId(1);
        assertEquals(1, response.size());
    }
}
