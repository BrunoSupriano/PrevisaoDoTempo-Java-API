package com.previsaotempo.controller;

import com.previsaotempo.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/previsao/{cidade}")
    public String getPrevisaoTempo(@PathVariable String cidade) {
        return weatherService.getWeatherByCity(cidade);
    }

    @GetMapping("/ajuda")
    public String getAjuda() {
        return "{\"estudante\": \"Bruno de Moraes Supriano\", \"projeto\": \"Previsão do Tempo\"}";
    }
}