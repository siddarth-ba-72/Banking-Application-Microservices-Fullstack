package com.finance.banking.AuthenticationService.ReqResBodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomersListResponseBody {
    private String message;
    private final boolean success = true;
    private HttpStatus status;
    private List<CustomerDetailsBody> users;
}
