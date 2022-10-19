package gruppe_12_backend.rest_api_12.repository;

import gruppe_12_backend.rest_api_12.model.Strain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StrainRepo extends CrudRepository<Strain,Integer> {
    public Strain findById(int id);

    public Set<Strain> findByType(String name);
}
