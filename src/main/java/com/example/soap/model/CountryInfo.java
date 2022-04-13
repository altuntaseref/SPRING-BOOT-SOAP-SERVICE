package com.example.soap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryInfo {
    private String countryName;
    private String capitalCity;
    private String currencyISOCode;
    private List<String> languages;


}
