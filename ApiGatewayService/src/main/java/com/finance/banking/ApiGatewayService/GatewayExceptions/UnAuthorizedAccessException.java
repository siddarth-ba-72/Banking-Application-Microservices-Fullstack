package com.finance.banking.ApiGatewayService.GatewayExceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UnAuthorizedAccessException extends RuntimeException {

    private HttpStatus errorStatus;

    public UnAuthorizedAccessException() {
        super("You cannot access this");
    }

    public UnAuthorizedAccessException(String errorMessage, HttpStatus status) {
        super(errorMessage);
        this.errorStatus = status;
    }
}
