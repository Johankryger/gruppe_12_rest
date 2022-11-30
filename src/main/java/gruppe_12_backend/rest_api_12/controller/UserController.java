package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.User;
import gruppe_12_backend.rest_api_12.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "User")
@ResponseBody
@RestController
@RequestMapping(path = "/users")
public class UserController {

    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Gets the current user", notes = "Gets the current authenticated user")
    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser(@RequestAttribute("username") String username) {
        return new ResponseEntity<User>(userService.getUsers(username), HttpStatus.OK);
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

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
