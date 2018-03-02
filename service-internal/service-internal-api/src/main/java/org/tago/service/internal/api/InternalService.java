package org.tago.service.internal.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by gvtaras on 3/1/2018.
 */
public interface InternalService extends Remote {

    public InternalServiceDto getSomeValue() throws RemoteException;
}
