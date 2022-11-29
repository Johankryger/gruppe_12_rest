package gruppe_12_backend.rest_api_12.service;

import javax.transaction.Transactional;
import gruppe_12_backend.rest_api_12.model.User;

public interface IUserService {


    public User getUsers(String username);

    public User getUser(Long id);

    public User addNewUser(User user);

    public void deleteUser(User user);

    @Transactional
    public void updateUser(Long userId, String first_name, String last_name, String email, String password,String gender); 
}
