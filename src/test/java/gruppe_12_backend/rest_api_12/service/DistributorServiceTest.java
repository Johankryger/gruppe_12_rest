package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Distributor;
import gruppe_12_backend.rest_api_12.repository.DistributorRepository;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


@SpringBootTest
class DistributorServiceTest {
    @Autowired
    private DistributorService ds;

    @Mock
    private DistributorRepository distributorRepository;

    @Test
    public void getDistributorsList() throws Exception {
        List<Distributor> distributorslist = ds.getAllDistributors();
        assertThat(distributorslist).isNotEmpty();
    }

    @Test
    public void getDistributor() throws Exception {

        Distributor testDistributor = new Distributor();
        testDistributor.setId(1L);
        Mockito.when(distributorRepository.findById(1L)).thenReturn(testDistributor);

        Distributor actualDistributor = ds.getDistributor(1L);

        assertNotNull(actualDistributor);
        assertEquals(testDistributor.getId(), actualDistributor.getId());
    }

    @Test
    public void createDistributor() {

        // Create test distributor (expected distributor)
        Distributor testDistributor = new Distributor();

        // Get id of last index and add (id +1) to the expected distributor
        List<Distributor> all = ds.getAllDistributors();
        testDistributor.setId(all.get(all.size() - 1).getId() + 1L);

        // Set other parameters and mock the save process
        testDistributor.setTitle("Test distributor");
        testDistributor.setDescription("This is a test distributor");
        Mockito.when(distributorRepository.save(Mockito.any(Distributor.class))).thenReturn(testDistributor);

        // Create new distributor and add title, description parameters
        Distributor newDistributor = new Distributor();
        newDistributor.setTitle("Test distributor");
        newDistributor.setDescription("This is a test distributor");
        // Save the distributor to the database
        ds.createDistributor(newDistributor);

        // Assertions
        assertNotNull(newDistributor);
        assertEquals(testDistributor.getId(), newDistributor.getId());
        assertEquals(testDistributor.getTitle(), newDistributor.getTitle());
        assertEquals(testDistributor.getDescription(), newDistributor.getDescription());

        // Cleanup
        ds.deleteDistributor(newDistributor);
    }

    @Test
    public void deleteDistributor() {
        // Sample data
        Distributor newDistributor = new Distributor();
        newDistributor.setTitle("New Distributor");
        // Save to database
        ds.createDistributor(newDistributor);

        // Assert you can get distributor
        assertNotNull(ds.getDistributor(newDistributor.getId()));

        // Delete the sample distributor
        ds.deleteDistributor(newDistributor);

        // Assert sample distributor cant be found in the database
        assertNull(ds.getDistributor(newDistributor.getId()));
    }
}
