package com.finance.banking.TransactionService.Controllers;

import com.finance.banking.TransactionService.ReqResBodies.TransactionDetails;
import com.finance.banking.TransactionService.ReqResBodies.TransactionResponseBody;
import com.finance.banking.TransactionService.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fin/trans")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/deposit/{amount}")
    public ResponseEntity<TransactionResponseBody> userDeposit(@RequestHeader("Authorization") String token, @PathVariable double amount) {
        TransactionDetails transactionDetails = transactionService.depositAmount(token, amount);
        TransactionResponseBody responseBody = TransactionResponseBody.builder()
                .message("Amount Deposited Successfully!")
                .status(HttpStatus.ACCEPTED)
                .transactionDetails(transactionDetails)
                .build();
        return new ResponseEntity<>(responseBody, HttpStatus.ACCEPTED);
    }
}
