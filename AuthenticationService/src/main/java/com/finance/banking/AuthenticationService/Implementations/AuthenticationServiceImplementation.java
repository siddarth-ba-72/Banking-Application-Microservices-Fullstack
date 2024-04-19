package com.finance.banking.AuthenticationService.Implementations;

import com.finance.banking.AuthenticationService.Entities.Customer;
import com.finance.banking.AuthenticationService.Entities.CustomerRole;
import com.finance.banking.AuthenticationService.Repositories.CustomerRepository;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerRequestBody;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService, UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomerDetailsBody registerCustomer(CustomerRequestBody customer) {
        Customer newCustomer = Customer.builder()
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .password(passwordEncoder.encode(customer.getPassword()))
                .accountNumber(customer.getAccountNumber())
                .ifscCode(customer.getIfscCode())
                .address(customer.getAddress())
                .balanceAmount(0.0)
                .role(CustomerRole.USER)
                .build();
        customerRepository.save(newCustomer);
        return this.buildCustomerResponseBody(newCustomer);
    }

    @Override
    public Customer loadUserByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber).orElse(null);
    }

    @Override
    public CustomerDetailsBody buildCustomerResponseBody(Customer customer) {
        return CustomerDetailsBody.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .accountNumber(customer.getAccountNumber())
                .ifscCode(customer.getIfscCode())
                .address(customer.getAddress())
                .balanceAmount(customer.getBalanceAmount())
                .role(customer.getRole())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return customerRepository.findByPhoneNumber(phoneNumber).orElse(null);
    }

    @Override
    public boolean isCustomerPhoneNumberExists(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber).isPresent();
    }

    @Override
    public boolean isCustomerAccountNumberExists(String accountNumber) {
        return customerRepository.findByAccountNumber(accountNumber).isPresent();
    }

    @Override
    public boolean isCustomerIfscCodeExists(String ifscCode) {
        return customerRepository.findByIfscCode(ifscCode).isPresent();
    }

    @Override
    public CustomerDetailsBody getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = (Customer) authentication.getPrincipal();
        return buildCustomerResponseBody(customer);
    }
}
