package com.CryptoPage.CryptoPage.controller;

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
    private static final String API_KEY = "03de0471-8a30-40f7-88c2-9567f60eade7";

    @GetMapping("/prices")
    public List<Map<String, Object>> getCryptoPrices() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(API_URL + "?limit=10", HttpMethod.GET, entity, Map.class);

        List<Map<String, Object>> cryptoList = (List<Map<String, Object>>) response.getBody().get("data");
        return cryptoList;
    }
}
