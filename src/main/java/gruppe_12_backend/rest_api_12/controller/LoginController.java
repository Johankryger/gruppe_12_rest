package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gruppe_12_backend.rest_api_12.TokenUtils;
import gruppe_12_backend.rest_api_12.exceptions.NotAuthorizedException;
import gruppe_12_backend.rest_api_12.model.LoginData;
import gruppe_12_backend.rest_api_12.model.User;
import io.swagger.annotations.Api;

@Api(tags = "Login")
@ResponseBody
@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping
    public String sendLoginData(@RequestBody LoginData data) throws NotAuthorizedException {

        if(data != null ) {
            User user = userService.getUsers(data.getUsername());
            if (user != null && user.getPassword().equals(data.getPassword())) {
                return TokenUtils.generateToken(userService.getUsers(data.getUsername()));
            }
        }
        throw new NotAuthorizedException("Wrong credentials");
    }

}
