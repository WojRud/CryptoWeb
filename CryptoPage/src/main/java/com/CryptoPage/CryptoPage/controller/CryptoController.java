package com.CryptoPage.CryptoPage.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

    private static final String API_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

    @Value("${coinmarketcap.api.key}")
    private String apiKey;

    @GetMapping("/prices")
    public List<Map<String, Object>> getCryptoPrices() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(
                API_URL + "?limit=10", HttpMethod.GET, entity, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return (List<Map<String, Object>>) response.getBody().get("data");
        } else {
            throw new RuntimeException("Błąd API: " + response.getStatusCode());
        }
    }
}
