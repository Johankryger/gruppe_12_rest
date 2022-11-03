package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Strain;
import gruppe_12_backend.rest_api_12.model.StrainType;
import gruppe_12_backend.rest_api_12.repository.StrainTypeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StrainTypeService {

    private StrainTypeRepo strainTypeRepo;

    public StrainTypeService(StrainTypeRepo strainTypeRepo) {
        this.strainTypeRepo = strainTypeRepo;
    }

    public List<StrainType> findAll() {
        List<StrainType> strainTypes = new ArrayList<>();
        strainTypeRepo.findAll().iterator().forEachRemaining(strainTypes::add);
        return strainTypes;
    }
}
