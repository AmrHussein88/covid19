package com.statistcs.covid19.controller;

import com.statistcs.covid19.dto.CountryDto;
import com.statistcs.covid19.service.WHOStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("covid19")
public class CountryStatisticsController {
    @Autowired
    private WHOStatisticsService whoStatisticsService;
    @GetMapping("/getLatestStatisticsByCountry/{countryName}")
    public CountryDto getStatisticsByCountry(@PathVariable("countryName") String countryName){
        return whoStatisticsService.retrieveStatisticsByCountryCode(countryName);
    }
}
