package com.finance.banking.AuthenticationService.Services;

import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;

public interface TransactionExternalServices {
    CustomerDetailsBody depositAmount(int customerId, double amount);
    CustomerDetailsBody withdrawAmount(int customerId, double amount);
}
