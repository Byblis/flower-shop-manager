package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // → templates/dashboard.html を表示する
    }
    @GetMapping("/dashboard/sales")
    public String showSales() {
        return "sales"; // sales.html を表示（仮）
    }
    @GetMapping("/dashboard/inventory")
    public String showInventory() {
        return "inventory"; // inventory.html を表示（仮）
    }
    @GetMapping("/dashboard/reservations")
    public String showreservations() {
        return "reservations"; 
    }
    @GetMapping("/dashboard/operations")
    public String showOperations() {
        return "operations"; // operations.html を表示（仮）
    }
    @GetMapping("/dashboard/admin/passcode")
    public String showAdminMenu() {
        return "admin-passcode"; // admin-passcode.html を表示（仮）
    }
}

