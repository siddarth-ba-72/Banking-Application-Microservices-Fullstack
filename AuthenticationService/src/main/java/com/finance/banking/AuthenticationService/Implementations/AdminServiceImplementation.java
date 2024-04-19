package com.finance.banking.AuthenticationService.Implementations;

import com.finance.banking.AuthenticationService.Entities.Customer;
import com.finance.banking.AuthenticationService.Entities.CustomerRole;
import com.finance.banking.AuthenticationService.Repositories.CustomerRepository;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.Services.AdminService;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public List<CustomerDetailsBody> getAllUsers() {
        List<Customer> list = customerRepository.findAllByRole(CustomerRole.USER);
        List<CustomerDetailsBody> users = new ArrayList<>();
        for(Customer c : list)
            users.add(authenticationService.buildCustomerResponseBody(c));
        return users;
    }
}
