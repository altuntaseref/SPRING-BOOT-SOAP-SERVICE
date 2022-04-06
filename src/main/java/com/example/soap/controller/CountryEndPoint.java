package com.example.soap.controller;

import com.example.soap.Client.CountryServiceClient;
import com.soap.client.gen.ListOfCountryNamesByCode;
import com.soap.client.gen.ListOfCountryNamesByCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndPoint {

    private static final String NAMESPACE="http://www.oorsprong.org/websamples.countryinfo";

    private CountryServiceClient countryClient;
    @Autowired
    public CountryEndPoint(CountryServiceClient countryClient) {
        this.countryClient = countryClient;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "ListOfCountryNamesByCode")
    @ResponsePayload
    public ListOfCountryNamesByCodeResponse respose(@RequestPayload ListOfCountryNamesByCode requestType){
        ListOfCountryNamesByCodeResponse responseType = new ListOfCountryNamesByCodeResponse();
        responseType = countryClient.listOfCountryNamesByCode(requestType);
        return responseType;
    }
}
