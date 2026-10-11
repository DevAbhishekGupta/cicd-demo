package com.example.cicddemo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service
public class PriceService {

    /** Applies a percentage discount (0-100) to an amount. */
    public BigDecimal applyDiscount(BigDecimal amount, int discountPercent) {
        if (amount == null || amount.signum() < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("discount must be between 0 and 100");
        }
        BigDecimal factor = BigDecimal.valueOf(100 - discountPercent)
                .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
        return amount.multiply(factor).setScale(2, RoundingMode.HALF_UP);
    }
}
