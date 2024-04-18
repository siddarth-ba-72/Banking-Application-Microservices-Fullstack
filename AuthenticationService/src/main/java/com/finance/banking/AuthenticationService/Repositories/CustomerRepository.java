package com.finance.banking.AuthenticationService.Repositories;

import com.finance.banking.AuthenticationService.Entities.Customer;
import com.finance.banking.AuthenticationService.Entities.CustomerRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByName(String name);

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    Optional<Customer> findByAccountNumber(String accountNumber);

    Optional<Customer> findByIfscCode(String ifscCode);

    Optional<Customer> findByRole(CustomerRole role);
}
