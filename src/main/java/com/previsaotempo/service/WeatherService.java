package com.previsaotempo.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public WeatherService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String getWeatherByCity(String cityName) {
        String API_URL = "https://api.openweathermap.org/data/2.5/weather";
        String apiUrl = String.format("%s?q=%s&units=metric&lang=pt&appid=%s", API_URL, cityName, apiKey);
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            String cidade = jsonNode.get("name").asText();
            double temperatura = jsonNode.get("main").get("temp").asDouble();
            String descricao = jsonNode.get("weather").get(0).get("description").asText();

            String mensagem = String.format("O clima atual em %s é %s, com temperatura de %.1f°C.", cidade, descricao, temperatura);

            return mensagem;}
        catch (Exception e) {
            e.printStackTrace();
            return "Erro ao processar a resposta da API.";
        }
    }
}