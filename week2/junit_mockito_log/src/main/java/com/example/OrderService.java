package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public boolean placeOrder(String id, double price) {
        logger.info("Placing order: {} with price: {}", id, price);
        if (price <= 0) {
            logger.warn("Invalid price: {}", price);
            throw new IllegalArgumentException("Price must be positive");
        }
        boolean saved = repository.saveOrder(id, price);
        if (saved) {
            logger.info("Order placed successfully");
        } else {
            logger.error("Failed to place order");
        }
        return saved;
    }
}