package com.finance.banking.AuthenticationService.ReqResBodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestBody {
    private String name;
    private String phoneNumber;
    private String password;
    private String accountNumber;
    private String ifscCode;
}
