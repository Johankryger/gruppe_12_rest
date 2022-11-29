package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "User")
@ResponseBody
@RestController
@RequestMapping(path = "/users")
public class UserController {

    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get user", notes = "Gets a user")
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        return new ResponseEntity<User>(userService.getUsers(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return new ResponseEntity<User>(userService.addNewUser(user) ,HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);

        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String sureName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String gender) {
        userService.updateUser(userId, firstName, sureName, email, password, gender);
    }
}
