package com.example.soap.config;

import com.example.soap.Client.CountryServiceClient;
import com.example.soap.controller.CountryEndPoint;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.transport.http.WsdlDefinitionHandlerAdapter;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import java.net.URL;

@Configuration
@EnableWs
@Data
public class Config extends WsConfigurerAdapter {

    private  CountryServiceClient serviceClient ;
    @Autowired
    public Config(CountryServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }


    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/country/*");
    }

    @Bean(name = "countryInfo")
    public Wsdl11Definition wsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/countryInfo.wsdl"));
        return wsdl11Definition;



    }

    String endpoint= "http://localhost:8083/websamples.countryinfo/CountryInfoService.wso";

    URL wsdl = Config.class.getClassLoader().getResource("/wsdl/countryInfo.wsdl");

    String namespace = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    String localName = "listOfCountryNamesByCode";





    /*
    http://localhost:8082/wsdlfirst/country
    http://localhost:9091/medium/ws/calculatorDemo
    http://localhost:8082/country/ws/country
    @Bean(name = "countryInfoService")
    public DefaultWsdl11Definition defaultWsdl11Definition()
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountryInfoServiceSoap");
        wsdl11Definition.setLocationUri("/service/country-code-name");
        wsdl11Definition.setTargetNamespace("http://www.oorsprong.org/websamples.countryinfo");
        wsdl11Definition.setSchema();

        return wsdl11Definition;
    }*/

}
