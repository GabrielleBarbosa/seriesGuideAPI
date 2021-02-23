package com.stags.seriesGuide.repository;

import com.stags.seriesGuide.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {

}
