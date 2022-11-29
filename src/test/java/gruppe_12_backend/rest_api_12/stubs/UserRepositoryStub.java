package gruppe_12_backend.rest_api_12.stubs;

import java.util.Optional;
import java.util.ArrayList;
import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.repository.UserRepository;

public class UserRepositoryStub implements UserRepository {
    

    private ArrayList<User> fakeStorage = new ArrayList<>();


    @Override
    public <S extends User> S save(S entity) {

        fakeStorage.add(entity);
        return entity;
    }
    
    @Override
    public void delete(User entity) {

        fakeStorage.remove(entity);
    }
    
    @Override
    public User findUserByEmail(String email) {

        for (User user : fakeStorage) {

            if (user.getEmail().equals(email)) {
                return user;
            }
            
        }
        return null; 
    }

    @Override
    public User findUserByUsername(String username) {

        for (User user : fakeStorage) {

            if (user.getUsername().equals(username)) {
                return user;
            }

        }
        return null;
    }

    @Override
    public User findUserById(Long id) {

        for (User user : fakeStorage) {

            if (user.getId().equals(id)) {
                return user;
            }

        }
        return null;
        
    }



    @Override
    public Optional<User> findById(Long id) {return Optional.empty();}

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {return null;}

    @Override
    public boolean existsById(Long id) {return false;}

    @Override
    public Iterable<User> findAll() {return null;}

    @Override
    public Iterable<User> findAllById(Iterable<Long> ids) {return null;}

    @Override
    public long count() {return 0;}

    @Override
    public void deleteById(Long id) {}


    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {}

    @Override
    public void deleteAll(Iterable<? extends User> entities) {}

    @Override
    public void deleteAll() {}

    
}
