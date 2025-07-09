package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberFlowController {

    @GetMapping("/member-lookup")
    public String showMemberLookupPage() {
        return "memberLookup";
    }

    @GetMapping("/point-grant")
    public String showPointGrantPage() {
        return "pointGrant";
    }
}

