package com.stags.seriesGuide.service;

import com.stags.seriesGuide.tmdb.SeriesSearch;
import com.stags.seriesGuide.tmdb.Series;
import com.stags.seriesGuide.tmdb.SeriesArray;
import com.stags.seriesGuide.tmdb.SeriesSearchResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TmdbService {

    private static String url = "https://api.themoviedb.org/3";
    private static String apiKey = "f110c9104cb779590def0b579f24a8a2";
    private static String basePosterUrl = "http://image.tmdb.org/t/p/";
    private static String sizePoster = "original";
    private RestTemplate restTemplate = new RestTemplate();

    private String urlEncodedParams(Map<String,String> params){
        return params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));
    }

    public SeriesArray searchSeriesByQuery(String name, int page) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("language", "pt-BR");
        params.put("query", name);
        params.put("page", page+"");
        params.put("api_key", apiKey);

        String uri = url + "/search/tv?" + urlEncodedParams(params);

        SeriesSearch result = restTemplate.getForObject(uri, SeriesSearch.class);

        List<Series> results = new ArrayList<>();

        for (SeriesSearchResult ssr : result.getResults()) {
            Series series = getSeriesById(ssr.getId());
            results.add(series);
        }

        return new SeriesArray(result.getTotal_pages(), results);
    }

    public SeriesArray getPopularSeries(int page) {
        Map<String, String> params = new HashMap<>();
        params.put("language", "pt-BR");
        params.put("page", page+"");
        params.put("api_key", apiKey);

        String uri = url + "/tv/popular?" + urlEncodedParams(params);

        SeriesSearch result = restTemplate.getForObject(uri, SeriesSearch.class);

        List<Series> results = new ArrayList<>();

        for (SeriesSearchResult stv : result.getResults()) {
            Series series = getSeriesById(stv.getId());
            results.add(series);
        }

        return new SeriesArray(result.getTotal_pages(), results);
    }

    public Series getSeriesById(long id){
        Map<String, String> params = new HashMap<>();
        params.put("language", "pt-BR");
        params.put("api_key", apiKey);

        String uri = url + "/tv/" + id + "?" + urlEncodedParams(params);
        Series series = restTemplate.getForObject(uri, Series.class);
        series.setPoster_path(basePosterUrl+sizePoster+ series.getPoster_path());
        return series;
    }

}
