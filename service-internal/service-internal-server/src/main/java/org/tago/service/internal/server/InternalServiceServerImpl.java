package org.tago.service.internal.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.InternalServiceDto;
import org.tago.service.internal.api.InternalServiceHolder;

/**
 * Created by gvtaras on 3/1/2018.
 */

@Component
public class InternalServiceServerImpl implements InternalService {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public InternalServiceDto getSomeValue() {
        return new InternalServiceDto(0L, "DTO from server");
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) throws RemoteException {
        // Add 'TEST' system property
        System.setProperty("TEST", getSomeValue().toString());

        // Register InternalServiceServerImpl in static field
        InternalServiceHolder.setInternalService(this);
        LOG.warn("Registering myself in static done");

        // Register InternalServiceServerImpl in RMI
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }

        String name = "RMI:INTERNAL_SERVER";
        InternalService engine = this;
        InternalService stub = (InternalService) UnicastRemoteObject.exportObject(engine, 0);

        Registry registry = LocateRegistry.getRegistry();
        registry.rebind(name, stub);

        LOG.warn("Registering myself in RMI done, name " + name);
    }
}
