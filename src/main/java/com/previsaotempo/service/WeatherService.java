package com.previsaotempo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherByCity(String cityName) {
        String API_URL = "https://api.openweathermap.org/data/2.5/weather";
        String apiUrl = String.format("%s?q=%s&units=metric&appid=%s", API_URL, cityName, apiKey);
        return restTemplate.getForObject(apiUrl, String.class);
    }
}