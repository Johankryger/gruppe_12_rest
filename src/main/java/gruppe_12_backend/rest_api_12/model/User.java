package gruppe_12_backend.rest_api_12.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author David Lukas Mikkelsen (s147197)
 */

@Entity
@NoArgsConstructor
public @Data class User {

    @Id
    @Getter
    @Setter
    @Length(min = 1, max = 128)
    private String userName;
    
    @Getter
    @Setter
    @Length(min = 1, max = 128)
    private String firstName;
    
    @Getter
    @Setter
    @Length(min = 1, max = 128)
    private String lastName;
    
    @Getter
    @Setter
    @Length(min = 1, max = 128)
    private String eMail;
    
    @Getter
    @Setter
    private String gender;
    
    @Getter
    @Setter
    @Length(min = 8, max = 128)
    private String password;
    
    @Getter
    @Setter
    @NotNull
    private Date birthday;
    
}
