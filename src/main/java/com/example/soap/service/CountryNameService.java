package com.example.soap.service;

import com.example.soap.Client.CountryServiceClient;
import com.example.soap.model.CountryInfo;
import com.soap.client.gen.CountryISOCode;
import com.soap.client.gen.FullCountryInfo;
import com.soap.client.gen.TLanguage;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Data

public class CountryNameService extends WebServiceGatewaySupport {

    private CountryServiceClient serviceClient;
    @Autowired
    public CountryNameService(CountryServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public CountryInfo getName(CountryISOCode countryName){
        CountryInfo allCountry = new CountryInfo();

        this.serviceClient.countryISOCodeResponse(countryName);
        FullCountryInfo fullCountryInfo = new FullCountryInfo();
        fullCountryInfo.setSCountryISOCode(this.serviceClient.countryISOCodeResponse(countryName).getCountryISOCodeResult());
        this.serviceClient.fullCountryInfoResponse(fullCountryInfo);

        List<TLanguage> countryLanguages = this.serviceClient.fullCountryInfoResponse(fullCountryInfo).getFullCountryInfoResult()
                .getLanguages().getTLanguage();


        List<String> language = new ArrayList<>();
        for(int i=0;i<countryLanguages.size();i++){
            List<String> lng = new ArrayList<>();
            lng.add(countryLanguages.get(i).getSName());
            lng.add(countryLanguages.get(i).getSISOCode());

            language.addAll(lng);

        }

        allCountry.setLanguages(language);
        allCountry.setCurrencyISOCode(this.serviceClient.fullCountryInfoResponse(fullCountryInfo).getFullCountryInfoResult()
                .getSCurrencyISOCode());
        allCountry.setCapitalCity( this.serviceClient.fullCountryInfoResponse(fullCountryInfo).getFullCountryInfoResult()
                .getSCapitalCity());
        allCountry.setCountryName(this.serviceClient.fullCountryInfoResponse(fullCountryInfo).getFullCountryInfoResult().getSName());
       return allCountry;
    }

}
