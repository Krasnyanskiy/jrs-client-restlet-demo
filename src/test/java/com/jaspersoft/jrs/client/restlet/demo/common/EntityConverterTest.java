package com.jaspersoft.jrs.client.restlet.demo.common;

import com.jaspersoft.jrs.client.restlet.demo.dto.ClientRole;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EntityConverterTest {

    private EntityConverter converter;
    private String entity ;

    @BeforeMethod
    public void before() {
        converter = new EntityConverter();
        entity = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<role>\n" +
                "<externallyDefined>true</externallyDefined>\n" +
                "<name>ROLE_SUPERUSER</name>\n" +
                "</role>";
    }

    @Test
    public void should_convert_string_to_proper_dto_entity() throws Exception {
        ClientRole role = converter.convert(entity, ClientRole.class);
        assertEquals(role.getName(), "ROLE_SUPERUSER");
        assertTrue(role.isExternallyDefined());
    }

    @AfterMethod
    public void after() {
        converter = null;
        entity = null;
    }
}