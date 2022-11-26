package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Distributor;
import gruppe_12_backend.rest_api_12.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DistributorService {
    @Autowired
    private DistributorRepository distributorRepository;

    public Distributor getDistributor(long id) {
        return distributorRepository.findById(id);
    }

    public List<Distributor> getAllDistributors() {
        List<Distributor> distributors = new ArrayList<>();
        distributorRepository.findAll().iterator().forEachRemaining(distributors::add);
        return distributors;
    }

    public long createDistributor(Distributor distributor) {
        List<Distributor> all = getAllDistributors();
        distributor.setId(all.get(all.size() - 1).getId() + 1L);

        distributorRepository.save(distributor);

        return distributor.getId();
    }

    public void deleteDistributor (Distributor distributor) {
        Optional<Distributor> existingDistributor = distributorRepository.findById(distributor.getId());

        if (existingDistributor.isPresent()) {
            distributorRepository.delete(distributor);
        }
    }
}
