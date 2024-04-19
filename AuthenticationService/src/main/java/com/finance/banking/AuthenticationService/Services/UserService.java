package com.finance.banking.AuthenticationService.Services;

import com.finance.banking.AuthenticationService.ReqResBodies.CustomerDetailsBody;
import com.finance.banking.AuthenticationService.ReqResBodies.UserUpdateRequestBody;

public interface UserService {
    CustomerDetailsBody updateUser(CustomerDetailsBody oldCustomer, UserUpdateRequestBody request);
}
