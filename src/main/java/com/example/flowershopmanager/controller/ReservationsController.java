package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationsController {

   @GetMapping("/reservations-flow")
public String showReservations() {
    return "reservations";
}

}

