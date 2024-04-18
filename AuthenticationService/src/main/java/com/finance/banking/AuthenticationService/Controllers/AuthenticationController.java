package com.finance.banking.AuthenticationService.Controllers;

import com.finance.banking.AuthenticationService.AuthExceptions.InValidLoginCredentialsException;
import com.finance.banking.AuthenticationService.AuthExceptions.InValidSignUpDetailsException;
import com.finance.banking.AuthenticationService.Entities.Customer;
import com.finance.banking.AuthenticationService.ReqResBodies.*;
import com.finance.banking.AuthenticationService.Security.JwtHelper;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fin/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtHelper helper;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseBody> registerCustomer(@RequestBody CustomerRequestBody request) {
        if(request.getPhoneNumber().length() != 10)
            throw new InValidSignUpDetailsException("Phone number must have 10 digits", HttpStatus.BAD_REQUEST);
        if(authenticationService.isCustomerPhoneNumberExists(request.getPhoneNumber()))
            throw new InValidSignUpDetailsException("Phone number already registered", HttpStatus.CONFLICT);
        if(authenticationService.isCustomerAccountNumberExists(request.getAccountNumber()))
            throw new InValidSignUpDetailsException("Account number already registered", HttpStatus.CONFLICT);
        if(authenticationService.isCustomerIfscCodeExists(request.getIfscCode()))
            throw new InValidSignUpDetailsException("IFSC Code already registered", HttpStatus.CONFLICT);
        if(request.getPassword().length() < 8)
            throw new InValidSignUpDetailsException("Password must be atleast 8 characters", HttpStatus.INTERNAL_SERVER_ERROR);
        CustomerDetailsBody customerDetails = authenticationService.registerCustomer(request);
        RegisterResponseBody responseBody = RegisterResponseBody.builder()
                .message("Customer Registered Successfully")
                .status(HttpStatus.OK)
                .customer(customerDetails)
                .build();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseBody> loginCustomer(@RequestBody LoginRequestBody request) {
        this.doAuthenticate(request.getPhoneNumber(), request.getPassword());
        Customer userDetails = authenticationService.loadUserByPhoneNumber(request.getPhoneNumber());
        String token = this.helper.generateToken(userDetails);
        CustomerDetailsBody loggedInCustomerDetails = authenticationService.buildCustomerResponseBody(userDetails);
        LoginResponseBody response = LoginResponseBody.builder()
                .message("Customer Logged In Successfully")
                .status(HttpStatus.OK)
                .jwtToken(token)
                .customer(loggedInCustomerDetails)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String phoneNumber, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(phoneNumber, password);
        try {
            manager.authenticate(authentication);
        } catch (InValidLoginCredentialsException e) {
            throw new InValidLoginCredentialsException(" Invalid Username or Password  !!", HttpStatus.BAD_REQUEST);
        }
    }
}
