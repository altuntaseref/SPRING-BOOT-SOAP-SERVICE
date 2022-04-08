package com.example.soap.Client;

import com.soap.client.gen.FullCountryInfo;
import com.soap.client.gen.FullCountryInfoResponse;
import com.soap.client.gen.ListOfCountryNamesByCode;
import com.soap.client.gen.ListOfCountryNamesByCodeResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

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

}
