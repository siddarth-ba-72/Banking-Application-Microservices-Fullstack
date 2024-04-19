package com.finance.banking.AuthenticationService.ReqResBodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateRequestBody {
    private String name;
    private String phoneNumber;
    private String accountNumber;
    private String ifscCode;
    private String address;
}
