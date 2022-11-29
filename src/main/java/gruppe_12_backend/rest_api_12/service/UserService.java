package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Our service class, that is responsible for all business logic.
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    public User getUser(Long id) {
        return userRepository.findUserById(id);
    }


    public void addNewUser(User user) {
        Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userID) {
        boolean exists = userRepository.existsById(userID);
        if (!exists) {
            throw new IllegalStateException("user with id " + userID + " does not exists");
        }
        userRepository.deleteById(userID);
    }

    @Transactional
    public void updateUser(Long userId,  String first_name, String last_name, String email, String password, String gender) {
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

            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()) {
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

        userRepository.save(user);
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
