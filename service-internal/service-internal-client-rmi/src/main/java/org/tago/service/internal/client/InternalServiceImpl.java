package org.tago.service.internal.client;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;
import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.InternalServiceDto;

/**
 * Created by gvtaras on 3/1/2018.
 */
@Component
public class InternalServiceImpl implements InternalService {

    @Override
    public InternalServiceDto getSomeObjValue() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/InternalService");
        rmiProxyFactory.setServiceInterface(InternalService.class);

        return ((InternalService)rmiProxyFactory.getObject()).getSomeObjValue();
    }

    @Override
    public String getSomeTextValue() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/InternalService");
        rmiProxyFactory.setServiceInterface(InternalService.class);

        return ((InternalService)rmiProxyFactory.getObject()).getSomeTextValue();
    }
}
