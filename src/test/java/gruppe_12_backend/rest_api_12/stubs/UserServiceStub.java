package gruppe_12_backend.rest_api_12.stubs;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.repository.UserRepository;
import gruppe_12_backend.rest_api_12.service.IUserService;


public class UserServiceStub implements IUserService {

    private UserRepository fakeDB = new UserRepositoryStub();


    @Override
    public User getUsers(String username) {

       return fakeDB.findUserByUsername(username); 
    }

    @Override
    public User getUser(Long id) {
        return fakeDB.findUserById(id);
    }

    @Override
    public User addNewUser(User user) {
        return fakeDB.save(user);
    }

    @Override
    public void deleteUser(User user) {
        fakeDB.delete(user);
    }

    @Override
    public void updateUser(Long userId, String first_name, String last_name, String email, String password,
            String gender) {

        
    }

}
