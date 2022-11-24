package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.StrainType;
import gruppe_12_backend.rest_api_12.repository.StrainTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StrainTypeService {

    private final StrainTypeRepository strainTypeRepository;

    public StrainTypeService(StrainTypeRepository strainTypeRepository) {
        this.strainTypeRepository = strainTypeRepository;
    }

    public List<StrainType> findAll() {
        List<StrainType> strainTypes = new ArrayList<>();
        strainTypeRepository.findAll().iterator().forEachRemaining(strainTypes::add);
        return strainTypes;
    }
}
