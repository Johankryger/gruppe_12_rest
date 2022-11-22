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

    @Autowired
    private DistributorRepository distributorRepository;

    public DistributorService(){
    }

    public Distributor getDistributor(long id) {
        return distributorRepository.findById(id);
    }

    public Iterable<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }
}
