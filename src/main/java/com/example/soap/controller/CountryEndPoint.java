package com.example.soap.controller;

import com.example.soap.Client.CountryServiceClient;
import com.soap.client.gen.FullCountryInfo;
import com.soap.client.gen.FullCountryInfoResponse;
import com.soap.client.gen.ListOfCountryNamesByCode;
import com.soap.client.gen.ListOfCountryNamesByCodeResponse;
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
           // log.info(responseType.getListOfCountryNamesByCodeResult().getTCountryCodeAndName().get(0).getSISOCode());
            return responseType;
        }catch (Exception e){
            log.error("Internal error", e.getMessage(),e);
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


}
