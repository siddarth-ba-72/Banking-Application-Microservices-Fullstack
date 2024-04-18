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
public class RegisterResponseBody {
    private String message;
    private final boolean success = true;
    private HttpStatus status;
    private CustomerDetailsBody customer;
}
