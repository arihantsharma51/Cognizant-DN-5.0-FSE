package com.example.loan_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.loan_service.model.Loan;
import com.example.loan_service.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @GetMapping("/{id}")
    public Loan getLoan(@PathVariable Long id) {

        return service.getLoan(id);

    }

}