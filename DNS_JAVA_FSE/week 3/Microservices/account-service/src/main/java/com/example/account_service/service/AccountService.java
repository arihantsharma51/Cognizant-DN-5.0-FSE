package com.example.account_service.service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.resilience4j.retry.annotation.Retry;
import com.example.account_service.dto.Loan;
import com.example.account_service.model.Account;

@Service
public class AccountService {
    @Autowired
    private WebClient webClient;
        @Retry(name = "loanServiceRetry")
        @CircuitBreaker(name = "loanService", fallbackMethod = "fallbackLoan")
        public Account getAccount(Long id) {
            System.out.println("Calling Loan Service...");

        Account account = new Account(
                id,
                "Rahul Sharma",
                50000
        );

        Loan loan = webClient.get()
                .uri("http://localhost:8082/loans/" + id)
                .retrieve()
                .bodyToMono(Loan.class)
                .block();

        account.setLoan(loan);

        return account;
    }

    public Account fallbackLoan(Long id, Exception ex) {

    Account account = new Account(
            id,
            "Rahul Sharma",
            50000
    );

    Loan loan = new Loan(
            0L,
            "Loan Service Unavailable",
            0.0
    );

    account.setLoan(loan);

    return account;

    }

}