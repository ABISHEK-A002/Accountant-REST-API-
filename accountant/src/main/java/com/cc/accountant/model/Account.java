package com.cc.accountant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    private int accountId;
    private String accountHolderName;
    private String username;
    private String password;
    private String accountNumber;
    private String accountPin;

    public Account() {
    }

    public Account(int accountId, String accountHolderName, String username, String password, String accountNumber, String accountPin) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.accountPin = accountPin;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(String accountPin) {
        this.accountPin = accountPin;
    }
}
