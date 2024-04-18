package com.finance.banking.ApiGatewayService.GatewayExceptions;

import com.finance.banking.ApiGatewayService.ReqResBodies.AuthErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GatewayExceptionHandlers {

    @ExceptionHandler(UnAuthenticatedAccessException.class)
    public ResponseEntity<AuthErrorResponse> handleUnAuthenticatedAccessException(
            UnAuthenticatedAccessException e
    ) {
        AuthErrorResponse errorResponse = AuthErrorResponse.builder()
                .errorMessage("Please login")
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnAuthorizedAccessException.class)
    public ResponseEntity<AuthErrorResponse> handleUnAuthorizedAccessException(
            UnAuthorizedAccessException e
    ) {
        AuthErrorResponse errorResponse = AuthErrorResponse.builder()
                .errorMessage("You cannot access this content")
                .status(HttpStatus.UNAUTHORIZED)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
