package com.example.cicddemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.example.cicddemo.service.PriceService;

@WebMvcTest(PriceController.class)
@Import(PriceService.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloDefaultsToWorld() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, World!"));
    }

    @Test
    void priceWithDiscount() throws Exception {
        mockMvc.perform(get("/api/price").param("amount", "200").param("discount", "25"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalPrice").value(150.00));
    }

    @Test
    void invalidDiscountReturns400() throws Exception {
        mockMvc.perform(get("/api/price").param("amount", "200").param("discount", "150"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").exists());
    }
}
