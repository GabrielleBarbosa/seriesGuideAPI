package com.stags.seriesGuide.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stags.seriesGuide.controller.RatingController;
import com.stags.seriesGuide.entity.Rating;
import com.stags.seriesGuide.models.RatingRequest;
import com.stags.seriesGuide.models.StatusRequest;
import com.stags.seriesGuide.repository.RatingRepository;
import com.stags.seriesGuide.service.RatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RatingController.class)
public class RatingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RatingService service;

    Rating mockRating = new Rating()
            .setSeriesId(1)
            .setUserId(1)
            .setComment("blabla")
            .setScore(8);

    @Test
    public void getRatingsBySeriesId() throws Exception {
        List<Rating> listRatings = new ArrayList<Rating>();
        listRatings.add(mockRating);
        when(service.getRatingsBySeriesId(any(Long.class))).thenReturn(listRatings);
        this.mockMvc.perform(get("/ratings/seriesId/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockRating.getComment())));
    }

    @Test
    public void getRatingsByUserId() throws Exception {
        List<Rating> listRatings = new ArrayList<Rating>();
        listRatings.add(mockRating);
        when(service.getRatingsByUserId(any(Long.class))).thenReturn(listRatings);
        this.mockMvc.perform(get("/ratings/userId/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockRating.getComment())));
    }

    @Test
    public void addRating() throws Exception {

        when(service.saveRating(any(RatingRequest.class)))
                .thenReturn(mockRating);
        this.mockMvc.perform(post("/ratings")
                .content((new ObjectMapper()).writeValueAsString(mockRating))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateRating() throws Exception{
        when(service.updateRating(any(RatingRequest.class))).thenReturn(mockRating);

        this.mockMvc.perform(put("/ratings")
                .content((new ObjectMapper()).writeValueAsString(mockRating))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
