package com.statistcs.covid19.service;

import com.statistcs.covid19.dto.CountryDto;
import com.statistcs.covid19.exception.RestTemplateErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class WHOStatisticsServiceImpl implements WHOStatisticsService{

    private   RestTemplate restTemplate;
    @Autowired
    public WHOStatisticsServiceImpl(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.errorHandler(new RestTemplateErrorHandler()).build();
    }
    private final String url = "https://api.covid19api.com/";

    @Override
    public CountryDto retrieveStatisticsByCountryCode(String country) {
        String byCountryUrl = url + "country/" + country;
      ResponseEntity<List<CountryDto>> countryResponseEntity = restTemplate.exchange(byCountryUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
      });
       List<CountryDto> countryDtoList = Objects.requireNonNull(countryResponseEntity.getBody()).stream()
               .sorted(Comparator.comparing(CountryDto::getDate).reversed()).collect(Collectors.toList());
        return countryDtoList.get(0);
    }
}
