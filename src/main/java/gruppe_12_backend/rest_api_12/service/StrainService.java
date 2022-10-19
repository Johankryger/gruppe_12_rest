package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Strain;
import gruppe_12_backend.rest_api_12.repository.StrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StrainService {

    @Autowired
    private StrainRepo strainRepo;

    public Strain getStrain(int id){
        return strainRepo.findById(id);
    }

    public Strain createStrain(Strain strain) {
        return strainRepo.save(strain);
    }
}
