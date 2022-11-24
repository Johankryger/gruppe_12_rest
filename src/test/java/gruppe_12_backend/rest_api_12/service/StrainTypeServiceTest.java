package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.StrainType;
import gruppe_12_backend.rest_api_12.repository.StrainTypeRepository;
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
public class StrainTypeServiceTest {

    @InjectMocks
    private StrainTypeService strainTypeService;

    @Mock
    private StrainTypeRepository strainTypeRepositoryMock;

    @Test
    public void findAll() {
        List<StrainType> mockStrainTypes = Collections.singletonList(new StrainType());
        Mockito.when(strainTypeRepositoryMock.findAll()).thenReturn(mockStrainTypes);

        List<StrainType> strainTypes = strainTypeService.findAll();

        assertEquals(strainTypes.size(), mockStrainTypes.size());
        assertEquals(strainTypes, mockStrainTypes);
    }
}