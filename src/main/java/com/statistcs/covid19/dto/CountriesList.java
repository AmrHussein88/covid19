package com.statistcs.covid19.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class CountriesList {
    private List<CountryDto> countryDtoList;
    public CountriesList(){
        countryDtoList = new ArrayList<>();
    }
}
