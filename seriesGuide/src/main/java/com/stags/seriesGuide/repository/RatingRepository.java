package com.stags.seriesGuide.repository;

import com.stags.seriesGuide.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(long userId);
    List<Rating> findBySeriesId(long seriesId);
}
