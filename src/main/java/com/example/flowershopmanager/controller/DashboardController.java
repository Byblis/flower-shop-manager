package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

  

    @GetMapping("/sales")
    public String showSales() {
        return "sales"; // sales.html を表示（仮）
    }

    @GetMapping("/inventory")
    public String showInventory() {
        return "inventory"; // inventory.html を表示（仮）
    }

    @GetMapping("/operations")
    public String showOperations() {
        return "operations"; // operations.html を表示（仮）
    }

    @GetMapping("/admin/passcode")
    public String showAdminMenu() {
        return "admin-passcode"; // admin-passcode.html を表示（仮）
    }
}

