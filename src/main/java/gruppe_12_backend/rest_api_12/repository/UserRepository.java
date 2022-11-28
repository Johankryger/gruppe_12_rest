package gruppe_12_backend.rest_api_12.repository;

import gruppe_12_backend.rest_api_12.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User,String> {
    User findByUserName(String userName);
}