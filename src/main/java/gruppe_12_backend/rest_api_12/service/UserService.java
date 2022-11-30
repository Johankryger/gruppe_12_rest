package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Objects;

// Our service class, that is responsible for all business logic.
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUsers(String username) {
        
        return userRepository.findUserByUsername(username);
    }

    public User getUser(Long id) {
        return userRepository.findUserById(id);
    }


    public User addNewUser(User user) {

        /* 
        User userFromStorage = userRepository.findUserByEmail(user.getEmail());
        if (userFromStorage.getEmail().equals(user.getEmail())) {
            throw new IllegalStateException("email taken");
        }
        */
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
       return userRepository.save(user);
    }

    public void deleteUser(User user) {

        long userID = user.getId();
        boolean exists = userRepository.existsById(userID);
        if (!exists) {
            throw new IllegalStateException("user with id " + userID + " does not exists");
        }
        userRepository.deleteById(userID);
    }

    @Transactional
    public void updateUser(User user) {



        User storedUser = userRepository.findUserById(user.getId());

        storedUser.setFirstName(user.getFirstName());
        storedUser.setLastName(user.getLastName());
        storedUser.setEmail(user.getEmail());
        storedUser.setGender(user.getGender());
        storedUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(storedUser);

        /*        
       
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id " + userId + " does not exists"
        ));

        if (first_name != null && first_name.length() > 0 && !Objects.equals(user.getFirst_name(), first_name)) {
            user.setFirst_name(first_name);
        }
        if (last_name != null && last_name.length() > 0 && !Objects.equals(user.getLast_name(), last_name)) {
            user.setLast_name(last_name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {

            User userFromStorage = userRepository.findUserByEmail(email);
            if (userFromStorage.getEmail().equals(user.getEmail())) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }

        if (gender != null && gender.length() > 0 && !Objects.equals(user.getGender(), gender)) {
            user.setGender(gender);
        }
        */

      
    }
/*
    @Transactional
    public void updateUser(Long userId, String name, String email) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(user.getFirstName(), name)) {
            user.setFirstName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
    }*/
}
