package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.service.UserService;
import gruppe_12_backend.rest_api_12.stubs.UserRepositoryStub;
import kong.unirest.HttpStatus;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;

public class UserControllerTest {

    private UserService userService;
    private UserController userController;


    @Test
    public void Get_User_Returns_Requested_User() throws Exception{

        //Arrange
        userService = new UserService(new UserRepositoryStub());
        userController = new UserController(userService);
        User testUser = new User();
        testUser.setUsername("JensErSej");
        testUser.setFirst_name("Jens");
        testUser.setLast_name("Larsen");
        testUser.setGender("Male");
        testUser.setEmail("Jens@test.dk");
        userService.addNewUser(testUser);

        //Act
        ResponseEntity<User> responseBody = userController.getUser(testUser.getUsername());
        User responseUser = responseBody.getBody();

        //Assert
        assertEquals(200, responseBody.getStatusCodeValue());
        assertEquals(testUser.getUsername(), responseUser.getUsername());
        assertEquals(testUser.getFirst_name(), responseUser.getFirst_name());
        assertEquals(testUser.getLast_name(), responseUser.getLast_name());
        assertEquals(testUser.getGender(), responseUser.getGender());
        assertEquals(testUser.getEmail(), responseUser.getEmail());

    }

    @Test
    public void Create_User_Adds_User_In_Storage() {

        //Arrange
        userService = new UserService(new UserRepositoryStub());
        userController = new UserController(userService);
        User testUser = new User();
        testUser.setUsername("Alan420");
        testUser.setFirst_name("Alan");
        testUser.setLast_name("Jensen");
        testUser.setGender("Transgender");
        testUser.setEmail("AlanFraBrøndby@test.dk");

        //Act
        ResponseEntity<User> responseBody = userController.createUser(testUser);
        User responseUser = responseBody.getBody();

        //Assert
        assertEquals(201, responseBody.getStatusCodeValue());
        assertEquals(testUser.getUsername(), responseUser.getUsername());
        assertEquals(testUser.getFirst_name(), responseUser.getFirst_name());
        assertEquals(testUser.getLast_name(), responseUser.getLast_name());
        assertEquals(testUser.getGender(), responseUser.getGender());
        assertEquals(testUser.getEmail(), responseUser.getEmail());

    }


    @Test
    public void Delete_User_Deletes_Specified_User_In_Storage() {

           //Arrange
           userService = new UserService(new UserRepositoryStub());
           userController = new UserController(userService);
           User testUser = new User();
           testUser.setUsername("Bente1963");
           testUser.setFirst_name("Bente");
           testUser.setLast_name("Hansen");
           testUser.setGender("Transgender woman");
           testUser.setEmail("Hansen@test.dk");
           userService.addNewUser(testUser);
           






    }
    


    
}
