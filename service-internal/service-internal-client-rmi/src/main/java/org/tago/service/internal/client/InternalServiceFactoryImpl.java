package org.tago.service.internal.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.InternalServiceFactory;

/**
 * Created by gvtaras on 3/1/2018.
 */
public class InternalServiceFactoryImpl extends InternalServiceFactory {

    public static InternalService getInternalService() throws RemoteException, NotBoundException {
        String name = "RMI:INTERNAL_SERVER";
        Registry registry = LocateRegistry.getRegistry();
        return (InternalService) registry.lookup(name);
    }
}
