package com.finance.banking.AuthenticationService.ReqResBodies;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginResponseBody {
    private String message;
    private final boolean success = true;
    private HttpStatus status;
    private String jwtToken;
    private CustomerDetailsBody customer;
}
