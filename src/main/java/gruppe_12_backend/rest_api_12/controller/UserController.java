package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "User")
@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "Get a user", notes = "Gets a new user")
    @GetMapping("/{userName}")
    public ResponseEntity<User> getUser(@PathVariable("userName") String userName) {
        return new ResponseEntity<>(userService.getUser(userName), HttpStatus.OK);
    }

    @ApiOperation(value = "Save a new user", notes = "Saves a new user")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a user", notes = "Updates a user's information" )
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete a user", notes = "Deletes an existing user")
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody User user) {

        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
