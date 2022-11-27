package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.Distributor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User")
@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "Save a new user", notes = "Saves a new user")
    @PostMapping
    public void createUser(@RequestBody String string) {
        System.out.println(string);
    }
}
