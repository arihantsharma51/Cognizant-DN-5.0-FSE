package com.example.account_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.account_service.model.Account;
import com.example.account_service.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {

        return service.getAccount(id);

    }

}