package org.tago.service.internal.api;

/**
 * Created by gvtaras on 3/1/2018.
 */
public class InternalServiceHolder {
    private static InternalService internalService;

    public static InternalService getInternalService() {
        return internalService;
    }

    public static void setInternalService(InternalService internalService) {
        InternalServiceHolder.internalService = internalService;
    }
}
