package com.example.financial_transactions.controller;

import com.example.financial_transactions.model.FinancialTransaction;
import com.example.financial_transactions.repository.FinancialTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class FinancialTransactionController {

    @Autowired
    private FinancialTransactionRepository financialTransactionRepository;

    @GetMapping("/transactions")
    public Mono<ResponseEntity<List<FinancialTransaction>>> fetchTransactions(
            @RequestParam String dateFrom,
            @RequestParam String dateTo,
            @RequestParam String userId,
            @RequestParam String service,
            @RequestParam int offset,
            @RequestParam int limit,
            @RequestParam String status,
            @RequestParam String reference) {

        Pageable pageable = PageRequest.of(offset, limit);
        return Mono.fromCallable(() -> financialTransactionRepository.findByDateBetweenAndUserIdAndServiceAndStatusAndReference(
                        dateFrom, dateTo, userId, service, status, reference, pageable))
                .map(Page::getContent)
                .map(transactions -> ResponseEntity.ok(transactions));
    }
}
