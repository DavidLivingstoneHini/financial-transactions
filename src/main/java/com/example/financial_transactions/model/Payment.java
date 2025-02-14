package com.example.financial_transactions.model;

public class Payment {
    private String id;

    // Constructor accepting an ID
    public Payment(String id) {
        this.id = id;
    }

    public Payment() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
