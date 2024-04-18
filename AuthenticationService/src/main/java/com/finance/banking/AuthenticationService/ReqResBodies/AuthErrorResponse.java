package com.finance.banking.AuthenticationService.ReqResBodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthErrorResponse {
    private String errorMessage;
    private final boolean success = false;
    private HttpStatus status;
}
