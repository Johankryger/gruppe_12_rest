package com.example.rest_demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//This interface is responsible for data access.
//This is our Data Access Layer. We are using this interface inside our service class,
// where all the business logic is implemented.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.email = ?1")
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

}
