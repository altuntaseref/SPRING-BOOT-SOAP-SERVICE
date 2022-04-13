package com.example.soap.controller;

import com.example.soap.Client.CountryServiceClient;
import com.soap.client.gen.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
public class CountryEndPoint {

    private CountryServiceClient countryClient;
    @Autowired
    public CountryEndPoint(CountryServiceClient countryClient) {
        this.countryClient = countryClient;
    }

    private static final String NAMESPACE_URI="http://www.oorsprong.org/websamples.countryinfo";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ListOfCountryNamesByCode")
    @ResponsePayload
    public ListOfCountryNamesByCodeResponse response(@RequestPayload ListOfCountryNamesByCode requestType){
        try {
            ListOfCountryNamesByCodeResponse responseType = new ListOfCountryNamesByCodeResponse();
            responseType = countryClient.listOfCountryNamesByCode(requestType);
            return responseType;
        }catch (Exception e){
            throw e;
        }

    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FullCountryInfo")
    @ResponsePayload
    public FullCountryInfoResponse fullCountryInfoResponse(@RequestPayload FullCountryInfo request ){

        FullCountryInfoResponse responseType = new FullCountryInfoResponse();
        responseType = countryClient.fullCountryInfoResponse(request);
        return responseType;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CountryISOCode")
    @ResponsePayload
    public CountryISOCodeResponse countryISOCodeResponse(@RequestPayload CountryISOCode request){

        CountryISOCodeResponse responseType = new CountryISOCodeResponse();

        responseType= countryClient.countryISOCodeResponse(request);
        return responseType;
    }

}
