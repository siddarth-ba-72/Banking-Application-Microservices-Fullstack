package com.finance.banking.AuthenticationService.ReqResBodies;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginRequestBody {
    private String phoneNumber;
    private String password;
}

