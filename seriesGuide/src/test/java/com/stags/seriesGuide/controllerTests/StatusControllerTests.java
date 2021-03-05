package com.stags.seriesGuide.controllerTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stags.seriesGuide.controller.StatusController;
import com.stags.seriesGuide.entity.Status;
import com.stags.seriesGuide.models.StatusRequest;
import com.stags.seriesGuide.service.StatusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StatusController.class)
public class StatusControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatusService service;


    Status mockStatus = new Status()
            .setSeriesId(1)
            .setUserId(1)
            .setStatus("blabla");

    @Test
    public void getStatusByUserId()throws Exception {
        List<Status> listStatus = new ArrayList<>();
        listStatus.add(mockStatus);
        when(service.getStatusByUserId(any(Long.class))).thenReturn(listStatus);
        this.mockMvc.perform(get("/status/userId/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockStatus.getStatus())));
    }

    @Test
    public void saveStatus() throws Exception {
        when(service.saveStatus(any(StatusRequest.class))).thenReturn(mockStatus);
        this.mockMvc.perform(post("/status")
                .content((new ObjectMapper()).writeValueAsString(mockStatus))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateStatus() throws Exception {

        when(service.updateStatus(any(StatusRequest.class))).thenReturn(mockStatus);

        this.mockMvc.perform(put("/status")
                .content((new ObjectMapper()).writeValueAsString(mockStatus))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetStatusById()throws Exception {
        when(service.getStatusById(any(Long.class))).thenReturn(mockStatus);
        this.mockMvc.perform(get("/status/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockStatus.getStatus())));
    }
}
