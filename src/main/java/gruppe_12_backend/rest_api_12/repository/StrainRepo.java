package gruppe_12_backend.rest_api_12.repository;

import gruppe_12_backend.rest_api_12.model.Strain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrainRepo extends CrudRepository<Strain,Integer> {
    Strain findById(int id);
}
