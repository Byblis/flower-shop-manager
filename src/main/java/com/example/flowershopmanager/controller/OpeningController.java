package com.example.flowershopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class OpeningController {

    @GetMapping("/dashboard/operations/opening")
public String showOpeningPage(Model model) {
    List<String> openingChecklist = List.of(
        "シャッターを開けた",
       "店内の清掃をした",
        "冷蔵庫を確認した",
        "レジを立ち上げた",
        "看板を出した",
        "💧 水やり確認",
        "🧹 掃除完了",
        "💰 レジ準備OK",
        "🏷️ POP・価格確認"
    );
    model.addAttribute("checklist", openingChecklist);
    return "operations-opening";
}

     @PostMapping("/dashboard/operations/doOpening")
    public String doOpening(Model model) {
        model.addAttribute("message", "🌞 開店処理が完了しました！");
        return "dashboard";
    }
}


