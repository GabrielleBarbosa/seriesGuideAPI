package com.stags.seriesGuide.controller;

import com.stags.seriesGuide.entity.Status;
import com.stags.seriesGuide.models.StatusRequest;
import com.stags.seriesGuide.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService service;

    @GetMapping("userId/{userId}")
    public List<Status> getStatusByUserId(@PathVariable long userId){
        return service.getStatusByUserId(userId);
    }

    @PostMapping()
    public Status saveStatus(@RequestBody StatusRequest status){
        return service.saveStatus(status);
    }

    @PutMapping()
    public Status updateStatus(@RequestBody StatusRequest status){
        Status result = service.updateStatus(status);
        return result;
    }

    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable long id){
        return service.getStatusById(id);
    }

}
