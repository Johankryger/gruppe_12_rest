package gruppe_12_backend.rest_api_12.repository;

import gruppe_12_backend.rest_api_12.model.Distributor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends CrudRepository<Distributor,Long> {
    Distributor findById(long id);
}
