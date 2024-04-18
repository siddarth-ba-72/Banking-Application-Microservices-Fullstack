package com.finance.banking.AuthenticationService.AuthExceptions;

import com.finance.banking.AuthenticationService.ReqResBodies.AuthErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthenticationExceptionHandlers {

    @ExceptionHandler(InValidSignUpDetailsException.class)
    public ResponseEntity<AuthErrorResponse> handleInValidSignUpDetailsException(InValidSignUpDetailsException e) {
        AuthErrorResponse errorResponse = AuthErrorResponse.builder()
                .errorMessage(e.getMessage())
                .status(e.getErrorStatus())
                .build();
        return new ResponseEntity<>(errorResponse, e.getErrorStatus());
    }

    @ExceptionHandler(InValidLoginCredentialsException.class)
    public ResponseEntity<AuthErrorResponse> handleInValidLoginCredentialsException(InValidLoginCredentialsException e) {
        AuthErrorResponse errorResponse = AuthErrorResponse.builder()
                .errorMessage(e.getMessage())
                .status(e.getErrorStatus())
                .build();
        return new ResponseEntity<>(errorResponse, e.getErrorStatus());
    }
}
