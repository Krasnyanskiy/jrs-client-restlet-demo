package com.jaspersoft.jrs.client.restlet.demo.service;


import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.data.Preference;
import org.restlet.engine.Engine;
import org.restlet.engine.connector.HttpClientHelper;
import org.restlet.resource.ClientResource;

import java.io.IOException;

public class RetrieveResourceTaskService {


    /** client constants **/
    private Engine instance = Engine.getInstance();
    private MediaType mediaType = new MediaType("application", "xml");


    /** result entity **/
    private String entity;


    public String retrieve(String... urls) {
        instance.getRegisteredClients().clear();
        instance.getRegisteredClients().add(new HttpClientHelper(null));

        ClientResource resource = new ClientResource(urls[0]);
        ChallengeScheme scheme = ChallengeScheme.HTTP_BASIC;
        ChallengeResponse auth = new ChallengeResponse(scheme, "superuser", "superuser");

        resource.setChallengeResponse(auth);
        resource.getClientInfo()
                .getAcceptedMediaTypes()
                .add(new Preference<>(mediaType));

        try {
            entity = resource.get(mediaType).getText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entity;
    }
}


