package com.example.soap.Client;

import com.soap.client.gen.ListOfCountryNamesByCode;
import com.soap.client.gen.ListOfCountryNamesByCodeResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.namespace.QName;
import java.net.URL;

public class CountryServiceClient extends WebServiceGatewaySupport {


    public ListOfCountryNamesByCodeResponse listOfCountryNamesByCode(ListOfCountryNamesByCode request){
        ListOfCountryNamesByCodeResponse response = (ListOfCountryNamesByCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",request);
        return response;

    }

}
