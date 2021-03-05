package com.stags.seriesGuide.serviceTests;

import com.stags.seriesGuide.entity.Rating;
import com.stags.seriesGuide.entity.Status;
import com.stags.seriesGuide.models.StatusRequest;
import com.stags.seriesGuide.repository.StatusRepository;
import com.stags.seriesGuide.service.RatingService;
import com.stags.seriesGuide.service.StatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatusServiceTests {

    @Mock
    private StatusRepository repository;

    @InjectMocks
    private StatusService service;

    @Test
    public void shouldReturnCreatedStatus(){
        StatusRequest statusRequest = new StatusRequest(1,"teste",1,1);
        when(repository.save(any(Status.class))).thenReturn(new Status().setStatus(statusRequest.getStatus()));
        Status response = service.saveStatus(statusRequest);
        assertEquals(statusRequest.getStatus(), response.getStatus());
    }

    @Test
    public void shouldReturnStatusByUserId(){
        Status status = new Status().setUserId(1).setStatus("bla");
        when(repository.findByUserId(any(Long.class))).thenReturn(Arrays.asList(status));
        List<Status> response = service.getStatusByUserId(1);
        assertEquals(1, response.size());
        assertEquals(status.getStatus(), response.get(0).getStatus());
    }

    @Test
    public void shouldReturnUpdatedStatus(){
        Status status = new Status().setUserId(1).setStatus("bla");
        when(repository.existsById(any(Long.class))).thenReturn(true);
        when(repository.findById(any(Long.class))).thenReturn(java.util.Optional.ofNullable(status));
        when(repository.save(any(Status.class))).thenReturn(status);
        Status response = service.updateStatus(new StatusRequest(1,"",1,1));
        assertNotNull(response);
        assertEquals(status.getStatus(), response.getStatus());
    }

    @Test
    public void updateShouldReturnNull(){
        when(repository.existsById(any(Long.class))).thenReturn(false);
        Status response = service.updateStatus(new StatusRequest(1,"",1,1));
        assertNull(response);
    }

    @Test
    public void shouldReturnStatusById(){
        Status status = new Status().setUserId(1).setStatus("bla");
        when(repository.findById(any(Long.class))).thenReturn(java.util.Optional.ofNullable(status));
        Status response = service.getStatusById(1);
        assertNotNull(response);
        assertEquals(status.getStatus(), response.getStatus());
    }
}
