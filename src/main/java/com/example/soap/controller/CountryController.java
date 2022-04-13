package com.example.soap.controller;

import com.example.soap.Client.CountryServiceClient;
import com.example.soap.model.CountryInfo;
import com.example.soap.service.CountryNameService;
import com.soap.client.gen.CountryISOCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class CountryController {

    private CountryServiceClient serviceClient;
    private CountryNameService countryNameService;
    private String countryName;

    @Autowired
    public CountryController(CountryServiceClient serviceClient,CountryNameService countryNameService) {
        this.serviceClient = serviceClient;
        this.countryNameService = countryNameService;

    }

    @GetMapping("/countryName")
    public CountryInfo countryName(CountryISOCode countryName){

        return this.countryNameService.getName(countryName);

    }


}
