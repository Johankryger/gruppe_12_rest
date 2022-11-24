package gruppe_12_backend.rest_api_12.repository;

import gruppe_12_backend.rest_api_12.model.StrainType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrainTypeRepository extends CrudRepository<StrainType, Long> {
}
