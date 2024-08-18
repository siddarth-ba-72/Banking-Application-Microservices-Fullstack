package com.finance.banking.AuthenticationService.Implementations;

import com.finance.banking.AuthenticationService.AuthExceptions.CustomerNotFoundException;
import com.finance.banking.AuthenticationService.Entities.Customer;
import com.finance.banking.AuthenticationService.Repositories.CustomerRepository;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import com.finance.banking.AuthenticationService.Services.TransactionExternalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImplementation implements TransactionExternalServices {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public CustomerDetailsBody depositAmount(int customerId, double amount) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found", HttpStatus.NOT_FOUND)
        );
        customer.setBalanceAmount(customer.getBalanceAmount() + amount);
        customerRepository.save(customer);
        return authenticationService.buildCustomerResponseBody(customer);
    }

    @Override
    public CustomerDetailsBody withdrawAmount(int customerId, double amount) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found", HttpStatus.NOT_FOUND)
        );
        customer.setBalanceAmount(customer.getBalanceAmount() - amount);
        customerRepository.save(customer);
        return authenticationService.buildCustomerResponseBody(customer);
    }
}
