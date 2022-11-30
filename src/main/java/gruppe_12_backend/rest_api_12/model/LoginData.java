package gruppe_12_backend.rest_api_12.model;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Class for holding login data associated with a user
 */
@Data
@NoArgsConstructor
public class LoginData {

    private String username;
    private String password;
    
}
