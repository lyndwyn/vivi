package ch.zhaw.vivi.config.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = SecurityException.class)
    public ResponseEntity<Object> securityException(SecurityException exception){

        return new ResponseEntity<>("You are not authorised to call this method.", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = IllegalAccessException.class)
    public ResponseEntity<Object> illegalAccessException(IllegalAccessException exception){

        return new ResponseEntity<>("You already gave this response", HttpStatus.METHOD_NOT_ALLOWED);
    }

}
