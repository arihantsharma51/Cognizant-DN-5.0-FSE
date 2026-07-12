package com.example.account_service.service;

import org.springframework.stereotype.Service;

import com.example.account_service.model.Account;

@Service
public class AccountService {

    public Account getAccount(Long id) {

        return new Account(
                id,
                "Rahul Sharma",
                50000.0
        );

    }

}