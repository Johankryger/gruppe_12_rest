package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Distributor;
import gruppe_12_backend.rest_api_12.model.Strain;
import gruppe_12_backend.rest_api_12.repository.StrainRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StrainService {

    private final StrainRepository strainRepository;

    public StrainService(StrainRepository strainRepository) {
        this.strainRepository = strainRepository;
    }

    public Strain getStrain(long id){
        return strainRepository.findById(id);
    }

    public Strain saveStrain(Strain strain) {
        return strainRepository.save(strain);
    }

    public List<Strain> findAll() {
        List<Strain> strains = new ArrayList<>();
        strainRepository.findAll().iterator().forEachRemaining(strains::add);
        return strains;
    }

    public Strain updateStrain(Long id, Strain strain) {
        strain.setId(id);
        return strainRepository.save(strain);
    }
}
