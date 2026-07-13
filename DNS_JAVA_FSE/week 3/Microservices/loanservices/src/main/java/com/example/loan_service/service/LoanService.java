package com.example.loan_service.service;

import org.springframework.stereotype.Service;

import com.example.loan_service.model.Loan;

@Service
public class LoanService {

    public Loan getLoan(Long id) {

        return new Loan(
                id,
                "Home Loan",
                2500000.0
        );

    }

}