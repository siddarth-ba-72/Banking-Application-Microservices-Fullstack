package com.finance.banking.AuthenticationService.Services;

import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;

import java.util.List;

public interface AdminService {
    List<CustomerDetailsBody> getAllUsers();
}
