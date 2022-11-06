package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Strain;
import gruppe_12_backend.rest_api_12.repository.StrainRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrainServiceTest {

    @InjectMocks
    private StrainService strainService;

    @Mock
    private StrainRepo strainRepoMock;

    @Test
    public void getStrain() {
        long testId = 123;
        Strain mockStrain = new Strain();
        mockStrain.setId(testId);
        Mockito.when(strainRepoMock.findById(testId)).thenReturn(mockStrain);

        Strain result = strainService.getStrain(testId);

        assertNotNull(result);
        assertEquals(result.getId(), testId);
    }

    @Test
    public void findAll() {
        List<Strain> mockStrains = Collections.singletonList(new Strain());
        Mockito.when(strainRepoMock.findAll()).thenReturn(mockStrains);

        List<Strain> strains = strainService.findAll();

        assertEquals(strains.size(), mockStrains.size());
        assertEquals(strains, mockStrains);
    }
}