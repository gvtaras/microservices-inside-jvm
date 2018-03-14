package org.tago.service.internal.api;

import java.io.Serializable;

/**
 * Created by gvtaras on 3/1/2018.
 */
public class InternalServiceDto implements Serializable {

    private final long id;
    private final String value;

    public InternalServiceDto(long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "InternalServiceDto{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
