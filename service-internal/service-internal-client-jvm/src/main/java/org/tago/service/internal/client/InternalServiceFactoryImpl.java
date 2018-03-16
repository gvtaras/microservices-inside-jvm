package org.tago.service.internal.client;

import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.InternalServiceFactory;
import org.tago.service.internal.api.InternalServiceHolder;

/**
 * Created by gvtaras on 3/1/2018.
 */
public class InternalServiceFactoryImpl extends InternalServiceFactory {

    public static InternalService getInternalService() {
        return InternalServiceHolder.getInternalService();
    }
}
