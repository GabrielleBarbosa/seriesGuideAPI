package com.stags.seriesGuide.repositoryTests;

import com.stags.seriesGuide.entity.Rating;
import com.stags.seriesGuide.entity.Status;
import com.stags.seriesGuide.repository.StatusRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StatusRepositoryTests {

    @Autowired
    StatusRepository repository;


    Status mockStatus = new Status()
            .setSeriesId(1)
            .setUserId(1)
            .setStatus("blabla");

    @Test
    public void shouldSaveAndReturnStatus(){

        repository.save(mockStatus);
        Integer countStatus = repository.findAll().size();
        assertEquals(1, countStatus);
    }

    @Test
    public void shouldReturnStatusByUserId(){

        repository.save(mockStatus);
        List<Status> result = repository.findByUserId(mockStatus.getUserId());
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void shouldUpdateStatus(){
        repository.save(mockStatus);

        mockStatus.setStatus("assistindo");

        repository.save(mockStatus);

        Status result = repository.findAll().get(0);
        assertEquals(mockStatus, result);

        int countStatus = repository.findAll().size();
        assertEquals(1, countStatus);

    }
}
