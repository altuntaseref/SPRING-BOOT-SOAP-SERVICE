package com.example.soap.config;

import com.example.soap.Client.CountryServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryClientConfig {

    @Value("${WSDL.ClientEndpoint}")
    private String clientEndpoint;


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.client.gen");
        return marshaller;
    }
    @Bean
    public CountryServiceClient countryClient(Jaxb2Marshaller marshaller) {
        CountryServiceClient client = new CountryServiceClient();
        client.setDefaultUri(clientEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
