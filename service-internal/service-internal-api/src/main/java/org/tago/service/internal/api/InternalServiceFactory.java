package org.tago.service.internal.api;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by gvtaras on 3/1/2018.
 */
public abstract class InternalServiceFactory {

    public static InternalService getInstance() {
        throw new NotImplementedException();
    }
}
