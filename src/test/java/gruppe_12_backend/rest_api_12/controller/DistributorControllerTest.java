package gruppe_12_backend.rest_api_12.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gruppe_12_backend.rest_api_12.model.Distributor;
import gruppe_12_backend.rest_api_12.service.DistributorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

class DistributorControllerTest extends AbstractTest {

    @Autowired
    private DistributorService ds;
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    @Test
    public void createDistributor() throws Exception {
        Distributor testDistributor = new Distributor();
        testDistributor.setTitle("Test distributor");

        String uri = "/distributors";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .content(asJsonString(testDistributor))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

        // Get the returned distributor object
        String content = mvcResult.getResponse().getContentAsString();
        Distributor distributor = super.mapFromJson(content, Distributor.class);

        assertNotNull(distributor);
        assertNotNull(distributor.getId());
        assertNotNull(distributor.getTitle());

        // Cleanup
        ds.deleteDistributor(distributor);
    }
}
