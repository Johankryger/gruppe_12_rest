package gruppe_12_backend.rest_api_12.service;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String userName) {

        return userRepository.findByUserName(userName);
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User updateUser(User user) {

        User newUser = new User();
        newUser.setGender(user.getGender());
        newUser.setEMail(user.getEMail());
        newUser.setPassword(user.getPassword());
        return userRepository.save(newUser);

    }

    public void deleteUser(User user) {

        userRepository.delete(user);
    }
    
}