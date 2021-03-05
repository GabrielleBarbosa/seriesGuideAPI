package com.stags.seriesGuide.service;

import com.stags.seriesGuide.entity.Status;
import com.stags.seriesGuide.models.StatusRequest;
import com.stags.seriesGuide.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository repository;

    public List<Status> getStatusByUserId(long userId){
        return repository.findByUserId(userId);
    }

    public Status saveStatus(StatusRequest status){
        Status s = new Status().setId(status.getId())
                .setStatus(status.getStatus())
                .setSeriesId(status.getSeriesId())
                .setUserId(status.getUserId());
        return repository.save(s);
    }

    public Status updateStatus(StatusRequest status){
        if(repository.existsById(status.getId())) {
            Status s = repository.findById(status.getId()).orElse(null);
            s.setStatus(status.getStatus());

            return repository.save(s);
        }
        return null;
    }

    public Status getStatusById(long id){
        return repository.findById(id).orElse(null);
    }
}
