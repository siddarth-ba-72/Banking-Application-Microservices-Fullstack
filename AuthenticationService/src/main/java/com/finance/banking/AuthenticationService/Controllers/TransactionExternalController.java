package com.finance.banking.AuthenticationService.Controllers;

import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import com.finance.banking.AuthenticationService.Services.TransactionExternalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fin/ext")
public class TransactionExternalController {

    @Autowired
    private TransactionExternalServices transactionServices;
    @Autowired
    private AuthenticationService authenticationService;

    @PutMapping("/dep/{amount}")
    public CustomerDetailsBody deposit(@PathVariable double amount) {
        CustomerDetailsBody customerDetailsBody = authenticationService.getUserDetails();
        return transactionServices.depositAmount(customerDetailsBody.getCustomerId(), amount);
    }

    @PutMapping("/with/{amount}")
    public CustomerDetailsBody withdraw(@PathVariable double amount) {
        CustomerDetailsBody customerDetailsBody = authenticationService.getUserDetails();
        return transactionServices.withdrawAmount(customerDetailsBody.getCustomerId(), amount);
    }
}
