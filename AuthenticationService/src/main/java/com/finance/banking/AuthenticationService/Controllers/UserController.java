package com.finance.banking.AuthenticationService.Controllers;

import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerResponseBody;
import com.finance.banking.AuthenticationService.ReqResBodies.UserUpdateRequestBody;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import com.finance.banking.AuthenticationService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fin/users")
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<CustomerResponseBody> retrieveCustomerDetails() {
        CustomerDetailsBody customerDetailsBody = authenticationService.getUserDetails();
        CustomerResponseBody responseBody = CustomerResponseBody.builder()
                .message("Customer Details")
                .status(HttpStatus.OK)
                .customer(customerDetailsBody)
                .build();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerResponseBody> updateUser(@RequestBody UserUpdateRequestBody request) {
        CustomerDetailsBody oldCustomer = authenticationService.getUserDetails();
        CustomerDetailsBody updatedCustomer = userService.updateUser(oldCustomer, request);
        CustomerResponseBody responseBody = CustomerResponseBody.builder()
                .message("Customer Details Updated Successfully")
                .status(HttpStatus.OK)
                .customer(updatedCustomer)
                .build();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
