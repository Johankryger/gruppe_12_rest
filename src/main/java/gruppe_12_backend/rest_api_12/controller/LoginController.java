package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.dto.LoginDto;
import gruppe_12_backend.rest_api_12.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import gruppe_12_backend.rest_api_12.utils.TokenUtils;
import gruppe_12_backend.rest_api_12.exceptions.NotAuthorizedException;
import gruppe_12_backend.rest_api_12.model.User;
import io.swagger.annotations.Api;

@Api(tags = "Login")
@ResponseBody
@RestController
@RequestMapping(path = "/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Authenticate", notes = "Authenticate using login credentials")
    @PostMapping(consumes = {"application/json"})
    public String sendLoginData(@RequestBody LoginDto data) throws NotAuthorizedException {

        if (data != null ) {
            User user = userService.getUsers(data.getUsername());
            if (user != null && BCrypt.checkpw(data.getPassword(), user.getPassword())) {
                return TokenUtils.generateToken(userService.getUsers(data.getUsername()));
            }
        }
        throw new NotAuthorizedException("Wrong credentials");
    }

}
