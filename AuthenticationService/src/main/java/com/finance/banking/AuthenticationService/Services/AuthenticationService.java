package com.finance.banking.AuthenticationService.Services;

import com.finance.banking.AuthenticationService.Entities.Customer;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerRequestBody;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;

public interface AuthenticationService {
    CustomerDetailsBody registerCustomer(CustomerRequestBody customer);
    CustomerDetailsBody buildCustomerResponseBody(Customer customer);
    Customer loadUserByPhoneNumber(String phoneNumber);
    boolean isCustomerPhoneNumberExists(String phoneNumber);
    boolean isCustomerAccountNumberExists(String accountNumber);
    boolean isCustomerIfscCodeExists(String ifscCode);
    CustomerDetailsBody getUserDetails();
}
