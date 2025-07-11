package com.example.flowershopmanager.controller;

import com.example.flowershopmanager.entity.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final String ADMIN_PASSCODE = "1234";

    // 🔐 管理者ログイン画面（GET）
    @GetMapping("/login")
    public String showLoginForm() {
        return "admin-passcode";
    }

    // 🔐 パスコード認証処理（POST）
    @PostMapping("/passcode")
    public String verifyPasscode(@RequestParam String passcode, Model model) {
        if (ADMIN_PASSCODE.equals(passcode)) {
            return "admin-dashboard";
        } else {
            model.addAttribute("error", "❌ パスコードが違います！");
            return "admin-passcode";
        }
    }

    // 🏠 管理者メニュー
    @GetMapping("/dashboard")
    public String showAdminMenu() {
        return "admin-dashboard";
    }

    // 📊 売上集計ページ
    @GetMapping("/sales")
    public String showSalesSummary(@RequestParam(required = false) String type,
                                   @RequestParam(required = false) String date,
                                   Model model) {

        // ✅ 架空データ（あとでDB接続に切替可能）
        List<Sale> salesData = List.of(
            new Sale(LocalDate.of(2025, 7, 9), 3000),
            new Sale(LocalDate.of(2025, 7, 9), 1500),
            new Sale(LocalDate.of(2025, 7, 10), 2200),
            new Sale(LocalDate.of(2025, 7, 11), 1800),
            new Sale(LocalDate.of(2025, 7, 15), 2000),
            new Sale(LocalDate.of(2025, 7, 25), 4500),
            new Sale(LocalDate.of(2025, 6, 30), 1700)
        );

        // 🕐 入力がなければ初期表示
        if (type == null || date == null || date.isEmpty()) {
            return "sales-summary";
        }

        LocalDate baseDate;
        try {
            baseDate = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            model.addAttribute("error", "📅 日付の形式が正しくありません！");
            return "sales-summary";
        }

        LocalDate from;
        LocalDate to;

        // ⏱ 集計範囲の決定
        switch (type) {
            case "day":
                from = baseDate;
                to = baseDate;
                break;
            case "week":
                WeekFields weekFields = WeekFields.of(Locale.JAPAN);
                from = baseDate.with(weekFields.dayOfWeek(), 1); // 月
                to = baseDate.with(weekFields.dayOfWeek(), 7);   // 日
                break;
            case "month":
                from = baseDate.withDayOfMonth(1);
                to = baseDate.withDayOfMonth(baseDate.lengthOfMonth());
                break;
            default:
                model.addAttribute("error", "⚠️ 無効な集計タイプです");
                return "sales-summary";
        }

        // 💰 売上計算
        int total = salesData.stream()
            .filter(sale -> !sale.getDate().isBefore(from) && !sale.getDate().isAfter(to))
            .mapToInt(Sale::getAmount)
            .sum();

        // 🧾 画面へ渡す
        model.addAttribute("totalSales", total);
        model.addAttribute("selectedType", type);
        model.addAttribute("selectedDate", baseDate);

        return "sales-summary";
    }

    // 🎁 クーポン・DM発行画面（GET）
    @GetMapping("/coupon")
    public String showCouponForm() {
    return "admin-coupon"; // ← admin-coupon.html に対応
}

    @PostMapping("/coupon")
    public String handleCouponSubmission(
        @RequestParam String title,
        @RequestParam String description,
        @RequestParam String discount,
        Model model) {

    // 仮：受け取った内容をログ or 表示に使う
    model.addAttribute("message", "クーポン「" + title + "」を発行しました！");
    return "admin-coupon"; // 発行後も同じ画面に戻る
}

}





