package com.finance.banking.TransactionService.ReqResBodies;

import com.finance.banking.TransactionService.Entities.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetails {
    private Integer transactionId;
    private String fromAccountNumber;
    private String toAccountNumber;
    private Double amount;
    private LocalDate date;
    private TransactionType transactionType;
}
