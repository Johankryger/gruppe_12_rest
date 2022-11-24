package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.Distributor;
import gruppe_12_backend.rest_api_12.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistributorService {

    private final DistributorRepository distributorRepository;

    public DistributorService(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    public Distributor getDistributor(long id) {
        return distributorRepository.findById(id);
    }

    public Iterable<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }

    public Distributor saveDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    public Distributor updateDistributor(Long id, Distributor distributor) {
        distributor.setId(id);
        return distributorRepository.save(distributor);
    }
}
