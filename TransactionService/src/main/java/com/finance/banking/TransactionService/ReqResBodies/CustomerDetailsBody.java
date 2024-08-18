package com.finance.banking.TransactionService.ReqResBodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDetailsBody {
    private Integer customerId;
    private String name;
    private String phoneNumber;
    private String accountNumber;
    private String ifscCode;
    private String address;
    private Double balanceAmount;
    private CustomerRole role;
}
