package com.jaspersoft.jrs.client.restlet.demo.common;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class EntityConverter {

    private Serializer serializer;

    public EntityConverter() {
        serializer = new Persister();
    }

    public <T> T convert(String entity, Class<T> entityClass) throws Exception {
        return serializer.read(entityClass, entity, false);
    }
}
