package com.example.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@Configuration
@EnableWs
public class Config extends WsConfigurerAdapter {


    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext)
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/service.wsdl","/service");
    }

    @Bean(name = "service")
    public Wsdl11Definition wsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/service.wsdl"));
        return wsdl11Definition;
    }
    /*
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
