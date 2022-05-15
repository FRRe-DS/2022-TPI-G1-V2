package dacs.tpi.login.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponseError<T> {
    private HttpStatus status;
    private T errors;
}
