package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

  

    @GetMapping("/dashboard/sales")
    public String showSales() {
        return "sales-dashboard"; // sales.html を表示（仮）
    }

    @GetMapping("/dashboard/inventory")
    public String showInventory() {
        return "inventory-dashboard"; // inventory.html を表示（仮）
    }
     @GetMapping("/dashboard/reservation")
    public String showreservation() {
        return "reservation-dashboard"; // inventory.html を表示（仮）
    }

    @GetMapping("/dashboard/operations")
    public String showOperations() {
        return "operations-dashboard"; // operations.html を表示（仮）
    }

    @GetMapping("/dashboard/admin/passcode")
    public String showAdminMenu() {
        return "admin-passcode-dashboard"; // admin-passcode.html を表示（仮）
    }
}

