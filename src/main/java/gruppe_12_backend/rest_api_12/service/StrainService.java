package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Strain;
import gruppe_12_backend.rest_api_12.repository.StrainRepo;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StrainService {
    StrainRepo strainRepo;
    StrainService(StrainRepo strainRepo){
        this.strainRepo = strainRepo;

    }

    public Strain getStrain(int id){
        return strainRepo.findById(id);
    }

    public Set<Strain> getStrains(String name){
        return strainRepo.findByType(name);
    }
}
