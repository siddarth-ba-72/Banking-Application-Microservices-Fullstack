package com.finance.banking.AuthenticationService.ReqResBodies;

import com.finance.banking.AuthenticationService.Entities.CustomerRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDetailsBody {
    private String name;
    private String phoneNumber;
    private String accountNumber;
    private String ifscCode;
    private Double balanceAmount;
    private CustomerRole role;
}
