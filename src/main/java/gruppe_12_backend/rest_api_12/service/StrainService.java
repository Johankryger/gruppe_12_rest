package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Strain;
import gruppe_12_backend.rest_api_12.repository.StrainRepo;
import org.springframework.stereotype.Service;

@Service
public class StrainService {

    private StrainRepo strainRepo;

    public StrainService(StrainRepo strainRepo) {
        this.strainRepo = strainRepo;
    }

    public Strain getStrain(int id){
        return strainRepo.findById(id);
    }

    public Strain createStrain(Strain strain) {
        return strainRepo.save(strain);
    }
}
