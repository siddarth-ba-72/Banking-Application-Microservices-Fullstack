package com.finance.banking.AuthenticationService.Entities;

public enum CustomerRole {
    USER("user"),
    ADMIN("admin");

    private final String role;

    CustomerRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
