package org.tago.service.internal.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tago.service.internal.api.InternalServiceDto;

/**
 * Created by gvtaras on 3/1/2018.
 */

@SpringBootApplication
@RestController
public class InternalServiceFrontController extends SpringBootServletInitializer {

    @Autowired
    private InternalServiceServerImpl server;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InternalServiceFrontController.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InternalServiceFrontController.class, args);
    }

    @RequestMapping("/")
    public InternalServiceDto index() {
        return server.getSomeValue();
    }



}
