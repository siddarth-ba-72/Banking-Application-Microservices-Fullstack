package com.finance.banking.AuthenticationService.Controllers;

import com.finance.banking.AuthenticationService.AuthExceptions.CustomerNotFoundException;
import com.finance.banking.AuthenticationService.AuthExceptions.UnAuthorizedAccessException;
import com.finance.banking.AuthenticationService.Entities.CustomerRole;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerResponseBody;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomersListResponseBody;
import com.finance.banking.AuthenticationService.Services.AdminService;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fin/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/allusers")
    public ResponseEntity<CustomersListResponseBody> getAllUsers() {
        if(authenticationService.getUserDetails().getRole() != CustomerRole.ADMIN)
            throw new UnAuthorizedAccessException("You must be Admin", HttpStatus.UNAUTHORIZED);
        CustomersListResponseBody responseBody = CustomersListResponseBody.builder()
                .message("List of all Users")
                .status(HttpStatus.OK)
                .users(adminService.getAllUsers())
                .build();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<CustomerResponseBody> deleteUser(@PathVariable int customerId) {
        if(!authenticationService.isCustomerIdExists(customerId))
            throw new CustomerNotFoundException("User with id: " + customerId +" not found", HttpStatus.NOT_FOUND);
        if(authenticationService.getUserByCustomerId(customerId).getRole() == CustomerRole.ADMIN)
            throw new UnAuthorizedAccessException("You cannot delete Admin User", HttpStatus.BAD_REQUEST);
        CustomerDetailsBody user = adminService.deleteUser(customerId);
        CustomerResponseBody response = CustomerResponseBody.builder()
                .message("User Deleted Successfully")
                .status(HttpStatus.OK)
                .customer(user)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
