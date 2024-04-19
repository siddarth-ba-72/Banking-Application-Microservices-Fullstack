package com.finance.banking.AuthenticationService.Controllers;

import com.finance.banking.AuthenticationService.AuthExceptions.UnAuthorizedAccessException;
import com.finance.banking.AuthenticationService.Entities.CustomerRole;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.ReqResBodies.CustomersListResponseBody;
import com.finance.banking.AuthenticationService.Services.AdminService;
import com.finance.banking.AuthenticationService.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
