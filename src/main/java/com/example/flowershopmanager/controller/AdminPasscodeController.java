package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPasscodeController {

    @GetMapping("/admin/passcode-flow")
    public String showAdminPasscodeFlow() {
        return "admin-passcode"; // admin-passcode.html を表示
    }
}

