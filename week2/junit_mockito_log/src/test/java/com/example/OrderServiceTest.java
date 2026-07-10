package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private OrderRepository repository;
    private OrderService service;

    @BeforeEach
    public void setUp() {
        repository = mock(OrderRepository.class);
        service = new OrderService(repository);
    }

    @Test
    public void testPlaceOrderSuccess() {
        when(repository.saveOrder("O101", 150.0)).thenReturn(true);
        boolean result = service.placeOrder("O101", 150.0);
        assertTrue(result);
        verify(repository, times(1)).saveOrder("O101", 150.0);
    }

    @Test
    public void testPlaceOrderInvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.placeOrder("O102", -5.0);
        });
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.0, 50.0, 100.0})
    public void testPlaceOrderMultiplePrices(double price) {
        when(repository.saveOrder(anyString(), anyDouble())).thenReturn(true);
        boolean result = service.placeOrder("O103", price);
        assertTrue(result);
    }

    @Test
    public void testPerformance() {
        assertTimeout(Duration.ofMillis(50), () -> {
            service.placeOrder("O104", 99.0);
        });
    }
}