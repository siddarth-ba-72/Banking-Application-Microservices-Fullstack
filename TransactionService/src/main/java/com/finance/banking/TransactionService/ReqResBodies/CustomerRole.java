package com.finance.banking.TransactionService.ReqResBodies;

import lombok.Getter;

@Getter
public enum CustomerRole {
    USER("user"),
    ADMIN("admin");

    private final String role;

    CustomerRole(String role) {
        this.role = role;
    }

}