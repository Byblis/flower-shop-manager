package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalesController {

    @GetMapping("/sales")
    public String showSalesFlow() {
        return "sales"; // → sales.html を表示
    }
}

