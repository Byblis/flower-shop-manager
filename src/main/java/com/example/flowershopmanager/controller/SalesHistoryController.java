// OKな書き方
package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalesHistoryController {

    @GetMapping("/sales-history")
    public String showSalesHistoryPage() {
        return "salesHistory";
    }
    
}
