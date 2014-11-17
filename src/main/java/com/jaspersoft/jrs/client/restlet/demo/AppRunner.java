package com.jaspersoft.jrs.client.restlet.demo;

import com.jaspersoft.jrs.client.restlet.demo.common.EntityConverter;
import com.jaspersoft.jrs.client.restlet.demo.dto.ClientRoleCollection;
import com.jaspersoft.jrs.client.restlet.demo.service.RetrieveResourceTaskService;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {


    private static RetrieveResourceTaskService taskService = new RetrieveResourceTaskService();
    private static EntityConverter converter = new EntityConverter();


    public static void main(String[] args) {
        try {
            String URL = "http://172.28.146.32:8080/jasperserver-pro/rest_v2/roles?user=superuser";
            String entityAsString = taskService.retrieve(URL);
            ClientRoleCollection clientRoles = converter.convert(entityAsString, ClientRoleCollection.class);
            System.out.println(clientRoles);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
