package hu.flowacademy.test.foodorder.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {

    private HttpStatus status;

    public ValidationException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
