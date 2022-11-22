package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.Distributor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

class DistributorControllerTest extends AbstractTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getDistributorsList() throws Exception {
        String uri = "/distributors";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        Distributor[] distributorslist = super.mapFromJson(content, Distributor[].class);
        assertTrue(distributorslist.length > 0);
    }

    @Test
    public void getDistributor() throws Exception {
        String uri = "/distributors/1";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        Distributor distributor = super.mapFromJson(content, Distributor.class);
        assertNotNull(distributor);
    }
}
