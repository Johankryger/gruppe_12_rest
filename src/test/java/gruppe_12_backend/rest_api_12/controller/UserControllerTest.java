package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.service.UserService;
import gruppe_12_backend.rest_api_12.stubs.UserRepositoryStub;
import org.springframework.http.HttpStatus;

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
        testUser.setId(1L);
        userService.addNewUser(testUser);

        //Act
        ResponseEntity<HttpStatus> response = userController.deleteUser(testUser);

        //Assert
        assertEquals(200, response.getStatusCode().value());
        assertNull(userService.getUser(testUser.getId()));

    }
    

    @Test
    public void Update_User_Updates_User_In_Storage() {

         //Arrange
         userService = new UserService(new UserRepositoryStub());
         userController = new UserController(userService);
         User testUserToBeOpdated = new User();
         testUserToBeOpdated.setUsername("Bente1963");
         testUserToBeOpdated.setFirst_name("Bente");
         testUserToBeOpdated.setLast_name("Hansen");
         testUserToBeOpdated.setGender("Transgender woman");
         testUserToBeOpdated.setEmail("Hansen@test.dk");
         testUserToBeOpdated.setId(1L);
         User testUser = new User();
         testUser.setUsername("Bente1963");
         testUser.setFirst_name("Bent");
         testUser.setLast_name(" Admin Jansen");
         testUser.setGender("Transgender man");
         testUser.setEmail("HansenAdmin@test.dk");
         testUser.setId(1L);
         userService.addNewUser(testUserToBeOpdated);

         //Act
         ResponseEntity<HttpStatus> response = userController.updateUser(testUser);
         

         //Assert
         User updatedUser = userController.getUser(testUser.getUsername()).getBody();

         assertEquals(204, response.getStatusCode().value());
         assertEquals(testUser.getFirst_name(), updatedUser.getFirst_name());
         assertEquals(testUser.getLast_name(), updatedUser.getLast_name());
         assertEquals(testUser.getGender(), updatedUser.getGender());
         assertEquals(testUser.getEmail(), updatedUser.getEmail());

    }
    
    
}
