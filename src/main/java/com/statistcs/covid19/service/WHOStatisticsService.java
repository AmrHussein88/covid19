package com.statistcs.covid19.service;

import com.statistcs.covid19.dto.CountryDto;

import java.util.List;

public interface WHOStatisticsService {
    CountryDto retrieveStatisticsByCountryCode(String countryCode);
}
