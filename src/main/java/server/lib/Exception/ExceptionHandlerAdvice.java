package server.lib.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(LinkException.class)
    public ResponseEntity linkHandler(LinkException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
