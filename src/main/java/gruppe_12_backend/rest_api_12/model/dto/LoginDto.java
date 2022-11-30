package gruppe_12_backend.rest_api_12.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class LoginDto {
    private String username;
    private String password;
}
