package com.stags.seriesGuide.controllerTests;

import com.stags.seriesGuide.controller.TmdbController;
import com.stags.seriesGuide.service.TmdbService;
import com.stags.seriesGuide.tmdb.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TmdbController.class)
public class TmdbControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TmdbService service;

    private Series mockSeries = new Series(1,
            new Date(),
            Arrays.asList(new Genre(1, "comédia")),
            "Teste",
            3,
            "Um teste sendo testado",
            "/teste.jpg",
            "filmando",
            10,
            1000000,
            "Test");

    private SeriesSearch mockSeriesSearch = new SeriesSearch( Arrays.asList(new SeriesSearchResult(1)), 1);

    @Test
    public void shouldReturnSeriesById() throws Exception{
        when(service.getSeriesById(any(Long.class))).thenReturn(mockSeries);
        this.mockMvc.perform(get("/series/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockSeries.getPoster_path())));
    }

    @Test
    public void shouldReturnPopularSeries() throws Exception{
        when(service.getPopularSeries(any(int.class))).thenReturn(new SeriesArray(1, Arrays.asList(mockSeries)));
        this.mockMvc.perform(get("/series/popular/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockSeries.getPoster_path())));
    }

    @Test
    public void getSeriesByQuery() throws Exception{
        when(service.searchSeriesByQuery(any(String.class), any(int.class))).thenReturn(new SeriesArray(1, Arrays.asList(mockSeries)));
        this.mockMvc.perform(get("/series/search?query=jhbd&page=1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(mockSeries.getPoster_path())));
    }

}
