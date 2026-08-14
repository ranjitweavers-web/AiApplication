package com.example.aiapplication.model;

public record Product(
        Long id,
        String name,
        String category,
        double price,
        int ram) {
}
