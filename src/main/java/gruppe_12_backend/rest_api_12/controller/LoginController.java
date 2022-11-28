package gruppe_12_backend.rest_api_12.controller;

import gruppe_12_backend.rest_api_12.model.User;
import io.swagger.annotations.Api;
import kong.unirest.Unirest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Api(tags = "Login")
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public RedirectView getLogin() {
        return new RedirectView("https://auth.dtu.dk/dtu/?service=https://grp12.servecounterstrike.com/api/login/redirect");
    }

    @GetMapping("/redirect")
    public String redirectCallback(@RequestParam String ticket) {
        String body = Unirest.get( "https://auth.dtu.dk/dtu/validate?service=https://grp12.servecounterstrike.com/api/login/redirect&ticket="
                        + ticket)
                .asString()
                .getBody();

        System.out.println(body);

        // validation here

        return body;
    }

    @GetMapping("/validate")
    public User validateToken(@RequestHeader("Authorization") String authHeader) {
        throw new NotImplementedException();
    }
}
