package org.tago.service.internal.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.RequestDto;
import org.tago.service.internal.api.ResponceDto;

/**
 * Created by gvtaras on 3/1/2018.
 */

@SpringBootApplication
@RestController
public class MainConfig extends SpringBootServletInitializer {

    @Autowired
    private InternalServiceServerImpl server;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainConfig.class);
    }

    @RequestMapping(value = "/obj", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponceDto getObject(RequestDto requestDto) {
        return server.getSomeObjValue(requestDto);
    }

    @RequestMapping("/str")
    public String getText() {
        return server.getSomeTextValue();
    }

    @Bean
    InternalServiceServerImpl internalServiceServer() {
        return new InternalServiceServerImpl();
    }

    @Bean
    RmiServiceExporter exporter(InternalServiceServerImpl internalServiceServer) {
        Class<InternalService> serviceInterface = InternalService.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(serviceInterface);
        exporter.setService(internalServiceServer);
        exporter.setServiceName(serviceInterface.getSimpleName());
        exporter.setRegistryPort(1099);
        return exporter;
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainConfig.class, args);
    }

}