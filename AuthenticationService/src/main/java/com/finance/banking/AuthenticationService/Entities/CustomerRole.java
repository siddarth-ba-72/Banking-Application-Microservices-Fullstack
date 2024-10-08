package com.finance.banking.AuthenticationService.Entities;

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
