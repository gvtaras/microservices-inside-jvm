package org.tago.service.internal.server;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.RequestDto;
import org.tago.service.internal.api.ResponceDto;
import org.tago.service.internal.api.InternalServiceHolder;

/**
 * Created by gvtaras on 3/1/2018.
 */

public class InternalServiceServerImpl implements InternalService {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    private Random random = new Random();

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {

        ResponceDto someValue = getSomeObjValue(new RequestDto(random.nextLong(), "In Memory Test"));
        LOG.warn("Registering myself: " + someValue);
        System.setProperty("TEST", someValue.toString());
        InternalServiceHolder.setInternalService(this);
    }

    @Override
    public ResponceDto getSomeObjValue(RequestDto request) {
        return new ResponceDto(0L, "DTO from server. Request value: " + request.getValue());
    }

    @Override
    public String getSomeTextValue() {
        return "Message from Server";
    }
}
