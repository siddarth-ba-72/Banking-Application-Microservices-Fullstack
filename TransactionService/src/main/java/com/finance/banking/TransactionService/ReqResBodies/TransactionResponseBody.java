package com.finance.banking.TransactionService.ReqResBodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponseBody {
    private String message;
    private final boolean success = true;
    private HttpStatus status;
    private TransactionDetails transactionDetails;
}
