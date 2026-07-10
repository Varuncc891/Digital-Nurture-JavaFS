package com.example;

public interface OrderRepository {
    boolean saveOrder(String id, double price);
}