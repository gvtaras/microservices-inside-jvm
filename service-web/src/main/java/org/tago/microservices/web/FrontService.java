package org.tago.microservices.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.InternalServiceDto;
import org.tago.service.internal.api.InternalServiceHolder;
import org.tago.service.internal.client.InternalServiceFactoryImpl;

/**
 * Created by gvtaras on 3/1/2018.
 */

@SpringBootApplication
@RestController
public class FrontService extends SpringBootServletInitializer {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    private InternalService internalService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FrontService.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FrontService.class, args);
    }

    @RequestMapping("/")
    public InternalServiceDto index() {
        // ToDo: bad, fix in a Spring way
        if (internalService == null) {
            internalService = InternalServiceFactoryImpl.getInternalService();
        }
        LOG.warn("TEST variable: " + System.getProperty("TEST"));
        return internalService.getSomeValue();
    }
}
