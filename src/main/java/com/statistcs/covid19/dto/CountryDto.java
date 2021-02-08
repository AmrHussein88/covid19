package com.statistcs.covid19.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.DocTreeVisitor;
import com.sun.source.doctree.SerialDataTree;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto implements SerialDataTree {
    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Province")
    private String province;
    @JsonProperty("city")
    private String city;
    @JsonProperty("CityCode")
    private String cityCode;
    @JsonProperty("Lat")
    private String lat;
    @JsonProperty("Lon")
    private String lon;
    @JsonProperty("Confirmed")
    private String confirmed;
    @JsonProperty("Deaths")
    private String deaths;
    @JsonProperty("Recovered")
    private String recovered;
    @JsonProperty("Active")
    private String active;
    @JsonProperty("Date")
    private Date date;

    @Override
    public List<? extends DocTree> getDescription() {
        return null;
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public Kind getKind() {
        return null;
    }

    @Override
    public <R, D> R accept(DocTreeVisitor<R, D> visitor, D data) {
        return null;
    }
}
