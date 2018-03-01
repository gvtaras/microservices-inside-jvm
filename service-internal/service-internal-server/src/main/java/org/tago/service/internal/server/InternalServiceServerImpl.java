package org.tago.service.internal.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.tago.service.internal.api.InternalServiceDto;
import org.tago.service.internal.api.InternalServiceHolder;

/**
 * Created by gvtaras on 3/1/2018.
 */

@Component
public class InternalServiceServerImpl implements org.tago.service.internal.api.InternalService {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public InternalServiceDto getSomeValue() {
        return new InternalServiceDto(0L, "DTO from server");
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        InternalServiceDto someValue = getSomeValue();
        LOG.warn("Registering myself: " + someValue);
        System.setProperty("TEST", someValue.toString());
        InternalServiceHolder.setInternalService(this);
    }
}
