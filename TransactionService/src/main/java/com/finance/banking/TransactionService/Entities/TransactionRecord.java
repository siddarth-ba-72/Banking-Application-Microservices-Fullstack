package com.finance.banking.TransactionService.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer transactionId;
    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
    private LocalDate date;
    private TransactionType transactionType;
}
