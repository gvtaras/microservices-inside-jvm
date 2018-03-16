package org.tago.service.internal.client;

import org.tago.service.internal.api.InternalService;
import org.tago.service.internal.api.RequestDto;
import org.tago.service.internal.api.ResponceDto;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by gvtaras on 3/1/2018.
 */
public class InternalServiceImpl implements InternalService {

    @Override
    public ResponceDto getSomeObjValue(RequestDto requestDto) {
        throw new NotImplementedException();
    }

    @Override
    public String getSomeTextValue() {
        throw new NotImplementedException();
    }
}
