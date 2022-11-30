package gruppe_12_backend.rest_api_12.repository;

import gruppe_12_backend.rest_api_12.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//This interface is responsible for data access.
//This is our Data Access Layer. We are using this interface inside our service class,
// where all the business logic is implemented.
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserById(Long id);

    User findUserByUsername(String username);

}
