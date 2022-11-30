package gruppe_12_backend.rest_api_12.utils;

import java.util.Calendar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gruppe_12_backend.rest_api_12.model.User;

public class TokenUtils {

    private static String EncryptionKey = "AthoneyErDum";
    private static final int TOKEN_EXPIRY = 2880; //  ca 2 dage

    /**
     * Method for generating a token to a specified user.
     * The token is generated by the HMAC512 algoritm utilizing
     * the SHA-512 hash function in combinaton with a key (AnthoneyErDum)
     * @param user to generate the token for
     * @return Token represented by a string
     */
    public static String generateToken(User user) {
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String token = objectMapper.writer().writeValueAsString(user);
            return JWT.create()
                    .withIssuer("GreenHelp")
                    .withClaim("user", token)
                    .withExpiresAt(expiry.getTime())
                    .sign(Algorithm.HMAC512(EncryptionKey));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Method for token validation
     * @param token to validate
     * @return if the token is valid the User with the claim is returned
     */
    public static User validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(EncryptionKey)).build();
        DecodedJWT verifyToken = verifier.verify(token);
        Claim user = verifyToken.getClaim("user");

        try {
            return new ObjectMapper().reader().forType(User.class)
                                     .readValue(user.asString());
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
    
    
}