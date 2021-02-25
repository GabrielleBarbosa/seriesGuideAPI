package com.stags.seriesGuide.repositoryTests;

import com.stags.seriesGuide.entity.Rating;
import com.stags.seriesGuide.entity.Status;
import com.stags.seriesGuide.repository.RatingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RatingRepositoryTests {

    @Autowired
    RatingRepository repository;

    Rating mockRating = new Rating()
            .setSeriesId(1)
            .setUserId(1)
            .setComment("blabla")
            .setScore(8);

    @Test
    public void addRating(){

        repository.save(mockRating);
        Integer countRatings = repository.findAll().size();
        assertEquals(1, countRatings);
    }

    @Test
    public void shouldReturnRatingsByUserId(){

        repository.save(mockRating);
        List<Rating> result = repository.findByUserId(mockRating.getUserId());
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(mockRating.getComment(), result.get(0).getComment());
    }

    @Test
    public void shouldReturnRatingsBySeriesId(){

        repository.save(mockRating);
        List<Rating> result = repository.findBySeriesId(mockRating.getSeriesId());
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(mockRating.getComment(), result.get(0).getComment());
    }

    @Test
    public void shouldUpdateRating(){
        repository.save(mockRating);

        mockRating.setScore(10);
        mockRating.setId(1);
        repository.save(mockRating);

        Integer countStatus = repository.findAll().size();
        assertEquals(1, countStatus);

        Rating result = repository.findAll().get(0);
        assertEquals(mockRating, result);
    }
}
