package com.finance.banking.TransactionService.ExternalServices;

import com.finance.banking.TransactionService.ReqResBodies.CustomerDetailsBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AUTHENTICATIONSERVICE")
public interface UserTransactionService {

    @PutMapping("/fin/ext/dep/{amount}")
    CustomerDetailsBody deposit(@RequestHeader("Authorization") String token, @PathVariable double amount);

    @PutMapping("/fin/ext/with/{amount}")
    CustomerDetailsBody withdraw(@RequestHeader("Authorization") String token, @PathVariable double amount);
}
