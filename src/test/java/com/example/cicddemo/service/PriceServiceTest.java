package com.example.cicddemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class PriceServiceTest {

    private final PriceService service = new PriceService();

    @Test
    void appliesDiscount() {
        assertEquals(new BigDecimal("90.00"), service.applyDiscount(new BigDecimal("100"), 10));
    }

    @Test
    void zeroDiscountKeepsPrice() {
        assertEquals(new BigDecimal("50.00"), service.applyDiscount(new BigDecimal("50"), 0));
    }

    @Test
    void fullDiscountIsFree() {
        assertEquals(new BigDecimal("0.00"), service.applyDiscount(new BigDecimal("80"), 100));
    }

    @Test
    void rejectsNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> service.applyDiscount(new BigDecimal("-1"), 10));
    }

    @Test
    void rejectsInvalidDiscount() {
        assertThrows(IllegalArgumentException.class,
                () -> service.applyDiscount(new BigDecimal("100"), 101));
    }
}
