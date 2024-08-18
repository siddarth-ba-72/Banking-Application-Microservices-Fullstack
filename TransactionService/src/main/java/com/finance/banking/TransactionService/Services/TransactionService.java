package com.finance.banking.TransactionService.Services;

import com.finance.banking.TransactionService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.TransactionService.ReqResBodies.TransactionDetails;

public interface TransactionService {
    TransactionDetails depositAmount(String token, double amount);
    TransactionDetails withdrawAmount(String token, double amount);
}
