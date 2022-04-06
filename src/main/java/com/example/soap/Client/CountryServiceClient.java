package com.example.soap.Client;

import com.soap.client.gen.ListOfCountryNamesByCode;
import com.soap.client.gen.ListOfCountryNamesByCodeResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryServiceClient extends WebServiceGatewaySupport {

    public ListOfCountryNamesByCodeResponse listOfCountryNamesByCode(ListOfCountryNamesByCode request){
        ListOfCountryNamesByCodeResponse response=(ListOfCountryNamesByCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
        return response;

    }

}
