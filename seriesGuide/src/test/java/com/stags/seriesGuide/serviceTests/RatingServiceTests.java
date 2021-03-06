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
import static org.junit.Assert.assertNull;
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

    @Test
    public void shouldReturnRatingByUserId(){
        when(repository.findByUserId(any(Long.class))).thenReturn(Arrays.asList(new Rating()));
        List<Rating> response = service.getRatingsByUserId(1);
        assertEquals(1, response.size());
    }

    @Test
    public void shouldReturnUpdatedRating(){
        Rating rating = new Rating();
        when(repository.existsById(any(Long.class))).thenReturn(true);
        when(repository.findById(any(Long.class))).thenReturn(java.util.Optional.of(rating));
        when(repository.save(any(Rating.class))).thenReturn(rating.setComment("teste"));
        Rating response = service.updateRating(new RatingRequest(1, 1, 1, "teste", 1));
        assertEquals("teste", response.getComment());
    }

    @Test
    public void updateShouldReturnNull(){
        Rating rating = new Rating();
        when(repository.existsById(any(Long.class))).thenReturn(false);
        Rating response = service.updateRating(new RatingRequest(1, 1, 1, "teste", 1));
        assertNull(response);
    }

    @Test
    public void shouldReturnRatingById(){
        when(repository.findById(any(Long.class))).thenReturn(java.util.Optional.ofNullable(new Rating().setComment("oiii")));
        Rating response = service.getRatingById(1);
        assertEquals("oiii", response.getComment());
    }
}
