package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperationsController {

    @GetMapping("/operations-flow")
    public String showOperationsFlow() {
        return "operations"; // operations.html を表示
    }

    @GetMapping("/dashboard/operations/opening")
    public String showOpeningPage() {
        return "operations-opening"; // ← operations-opening.html を表示
    }

    @GetMapping("/dashboard/operations/closing")
    public String showClosingPage() {
        return "operations-closing"; // ← operations-closing.html を表示
    }

}

