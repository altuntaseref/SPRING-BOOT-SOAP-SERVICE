package com.example.soap.Client;

import com.soap.client.gen.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
@Slf4j
public class CountryServiceClient extends WebServiceGatewaySupport {


    public ListOfCountryNamesByCodeResponse listOfCountryNamesByCode(ListOfCountryNamesByCode request){
        ListOfCountryNamesByCodeResponse response = (ListOfCountryNamesByCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",request);
        return response;

    }

    public FullCountryInfoResponse fullCountryInfoResponse(FullCountryInfo sCountryISOCode ){
        FullCountryInfoResponse response = (FullCountryInfoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",sCountryISOCode);
        return response;
    }



    public CountryISOCodeResponse countryISOCodeResponse( CountryISOCode request){
        CountryISOCodeResponse response = (CountryISOCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",request);
        return response;
    }

}
