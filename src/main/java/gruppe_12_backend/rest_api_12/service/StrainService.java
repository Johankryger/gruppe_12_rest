package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Strain;
import gruppe_12_backend.rest_api_12.repository.StrainRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public List<Strain> findAll() {
        List<Strain> strains = new ArrayList<>();
        strainRepo.findAll().iterator().forEachRemaining(strains::add);
        return strains;
    }
}
