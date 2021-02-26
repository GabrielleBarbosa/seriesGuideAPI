package com.stags.seriesGuide.serviceTests;

import com.stags.seriesGuide.service.TmdbService;
import com.stags.seriesGuide.tmdb.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TmdbServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
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
    public void shouldReturnSeriesById(){
        when(restTemplate.getForObject(anyString(), ArgumentMatchers.any(Class.class))).thenReturn(mockSeries);
        Series response = service.getSeriesById(1L);
        assertNotNull(response);
        assertEquals(mockSeries.getName(), response.getName());
    }

    @Test
    public void shouldReturnSeriesByQuery(){
        when(restTemplate.getForObject(anyString(), ArgumentMatchers.any(Class.class))).thenAnswer(
                invocationOnMock -> {
                    Object argument = invocationOnMock.getArgument(1);
                    if(argument.equals(Series.class))
                        return mockSeries;
                    return mockSeriesSearch;
                }
        );
        SeriesArray response = service.searchSeriesByQuery("k", 1);
        assertNotNull(response);
        assertEquals(mockSeries.getName(), response.getResults().get(0).getName());
    }

    @Test
    public void shouldReturnPopularSeries(){
        when(restTemplate.getForObject(anyString(), ArgumentMatchers.any(Class.class))).thenAnswer(
                invocationOnMock -> {
                    Object argument = invocationOnMock.getArgument(1);
                    if(argument.equals(Series.class))
                        return mockSeries;
                    return mockSeriesSearch;
                }
        );
        SeriesArray response = service.getPopularSeries( 1);
        assertNotNull(response);
        assertEquals(mockSeries.getName(), response.getResults().get(0).getName());
    }
}
