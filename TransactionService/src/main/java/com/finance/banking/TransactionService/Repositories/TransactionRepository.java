package com.finance.banking.TransactionService.Repositories;

import com.finance.banking.TransactionService.Entities.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionRecord, Integer> {
}
