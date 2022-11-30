package gruppe_12_backend.rest_api_12.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gruppe_12_backend.rest_api_12.TokenUtils;
import gruppe_12_backend.rest_api_12.exceptions.NotAuthorizedException;
import gruppe_12_backend.rest_api_12.model.LoginData;
import gruppe_12_backend.rest_api_12.model.User;
import io.swagger.annotations.Api;

@Api(tags = "Login")
@ResponseBody
@RestController
@RequestMapping(path = "/")
public class LoginController {

    @PostMapping
    public String sendLoginData(LoginData data) throws NotAuthorizedException {

        if(data != null && "someUserName".equals(data.getUserName()) 
                && "SomePassword".equals(data.getPassword())) {

            //TODO her skal vi lave en bruger med det nye username
            return TokenUtils.generateToken(new User());
        }
        throw new NotAuthorizedException("Wrong credentials");
    }

}
