package com.finance.banking.TransactionService.Implementations;

import com.finance.banking.TransactionService.Entities.TransactionRecord;
import com.finance.banking.TransactionService.Entities.TransactionType;
import com.finance.banking.TransactionService.ExternalServices.UserTransactionService;
import com.finance.banking.TransactionService.Repositories.TransactionRepository;
import com.finance.banking.TransactionService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.TransactionService.ReqResBodies.TransactionDetails;
import com.finance.banking.TransactionService.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserTransactionService userTransactionService;

    @Override
    public TransactionDetails depositAmount(String token, double amount) {
        CustomerDetailsBody customer = userTransactionService.deposit(token, amount);
        TransactionRecord transaction = TransactionRecord.builder()
                .fromAccountNumber(customer.getAccountNumber())
                .toAccountNumber(customer.getAccountNumber())
                .amount(amount)
                .transactionType(TransactionType.DEPOSIT)
                .date(LocalDate.now())
                .build();
        return buildTransactionDetails(transaction);
    }

    @Override
    public TransactionDetails withdrawAmount(String token, double amount) {
        CustomerDetailsBody customer = userTransactionService.withdraw(token, amount);
        TransactionRecord transaction = TransactionRecord.builder()
                .fromAccountNumber(customer.getAccountNumber())
                .toAccountNumber(customer.getAccountNumber())
                .amount(amount)
                .transactionType(TransactionType.WITHDRAWAL)
                .date(LocalDate.now())
                .build();
        return buildTransactionDetails(transaction);
    }

    public TransactionDetails buildTransactionDetails(TransactionRecord transaction) {
        return TransactionDetails.builder()
                .transactionId(transaction.getTransactionId())
                .fromAccountNumber(transaction.getFromAccountNumber())
                .toAccountNumber(transaction.getToAccountNumber())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .transactionType(transaction.getTransactionType())
                .build();
    }
}
