package com.finance.banking.ApiGatewayService.GatewayExceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UnAuthenticatedAccessException extends RuntimeException{

    private HttpStatus errorStatus;

    public UnAuthenticatedAccessException() {
        super("Please Login");
    }

    public UnAuthenticatedAccessException(String errorMessage, HttpStatus status) {
        super(errorMessage);
        this.errorStatus = status;
    }
}
