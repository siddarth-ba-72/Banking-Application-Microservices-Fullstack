package com.finance.banking.AuthenticationService.Implementations;

import com.finance.banking.AuthenticationService.Entities.Customer;
import com.finance.banking.AuthenticationService.Repositories.CustomerRepository;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.ReqResBodies.UserUpdateRequestBody;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import com.finance.banking.AuthenticationService.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImplementation implements UserService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public CustomerDetailsBody updateUser(CustomerDetailsBody oldCustomer, UserUpdateRequestBody request) {
        Customer customer = customerRepository.findById(oldCustomer.getCustomerId()).orElse(null);
        if(customer == null)
            return null;
        customer.setName(request.getName());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setAccountNumber(request.getAccountNumber());
        customer.setIfscCode(request.getIfscCode());
        customer.setAddress(request.getAddress());
        customerRepository.save(customer);
        return authenticationService.buildCustomerResponseBody(customer);
    }
}
