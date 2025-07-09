package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryController {

    @GetMapping("/inventory-flow")
    public String showInventoryFlow() {
        return "inventory"; // inventory.html を表示
    }
}

