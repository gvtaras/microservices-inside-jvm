package org.tago.microservices.web;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.RequestDto;
import org.tago.service.internal.api.ResponceDto;

/**
 * Created by gvtaras on 3/1/2018.
 */

@SpringBootApplication
@RestController
public class FrontService extends SpringBootServletInitializer {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    private InternalService internalService;

    private Random random = new Random();

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FrontService.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FrontService.class, args);
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/InternalService");
        rmiProxyFactory.setServiceInterface(InternalService.class);
        return rmiProxyFactory;
    }

    @RequestMapping("/obj")
    public ResponceDto getObj(@Autowired RmiProxyFactoryBean rmiProxyFactoryBean) {
        RequestDto request = new RequestDto(random.nextLong(), "Request from service-web");
        return ((InternalService) rmiProxyFactoryBean().getObject()).getSomeObjValue(request);
    }

    @RequestMapping("/str")
    public String getString(@Autowired RmiProxyFactoryBean rmiProxyFactoryBean) {
        return ((InternalService) rmiProxyFactoryBean().getObject()).getSomeTextValue();
    }

//    @RequestMapping("/")
//    public ResponceDto index() {
//        // ToDo: bad, fix in a Spring way
//        if (internalService == null) {
//            internalService = InternalServiceFactoryImpl.getInternalService();
//        }
//        LOG.warn("TEST variable: " + System.getProperty("TEST"));
//        return internalService.getSomeValue();
//    }
}
