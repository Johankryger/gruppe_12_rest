package gruppe_12_backend.rest_api_12.exceptions;

import java.io.Serializable;

import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotAuthorizedException extends Throwable {

    public NotAuthorizedException(String str) {
        super((str));
    }
    
    
    public class NorAuthorizedExceptionMapper implements Serializable {

        //TODO: lav den lorte exception færdig
        /* 
        @Override
        public ResponseEntity<NotAuthorizedException> toResponseEntity(NotAuthorizedException e) {
            return new ResponseEntity<NotAuthorizedException>(e, HttpStatus.UNAUTHORIZED);
        }
        */
    }


    
}
