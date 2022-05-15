package dacs.tpi.login.exception.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dacs.tpi.login.exception.ApiResponseError;
import dacs.tpi.login.exception.BlankFieldException;

@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler{
    
	@ExceptionHandler(BlankFieldException.class)
    public ResponseEntity<ApiResponseError<String>> handleBlankFieldException(BlankFieldException ex){
        return new ResponseEntity<>(
                new ApiResponseError<>(
                        HttpStatus.BAD_REQUEST,
                        ex.getMessage()
                ),
          HttpStatus.BAD_REQUEST
        );
    }

}
