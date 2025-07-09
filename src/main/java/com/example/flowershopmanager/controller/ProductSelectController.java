package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductSelectController {

    @GetMapping("/product-select")
    public String showProductSelectPage() {
        return "productSelect";
    }
}

