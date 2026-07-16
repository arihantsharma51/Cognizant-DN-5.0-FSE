package com.example.account_service.model;

import com.example.account_service.dto.Loan;

public class Account {

    private Long accountId;
    private String accountHolderName;
    private double balance;
    private Loan loan;

    public Account() {
    }

    public Account(Long accountId, String accountHolderName, double balance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        
    }
    public Loan getLoan() {
    return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}