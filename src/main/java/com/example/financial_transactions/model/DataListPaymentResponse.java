package com.example.financial_transactions.model;

import java.util.List;

public class DataListPaymentResponse {
    private List<Payment> payments;

    // Getters and Setters
    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
