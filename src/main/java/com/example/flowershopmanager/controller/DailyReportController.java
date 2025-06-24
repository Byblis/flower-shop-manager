package com.example.flowershopmanager.controller;

import com.example.flowershopmanager.entity.DailyReport;
import com.example.flowershopmanager.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DailyReportController {

    @Autowired
    private DailyReportService service;

    @PostMapping("/dashboard/operations/submitReport")
    public String submitReport(@RequestParam("report") String reportContent, Model model) {
        service.saveReport(reportContent);
        model.addAttribute("message", "日報が保存されました！");
        return "operations-closing";
    }

    @GetMapping("/reports")
    public String showReportList(Model model) {
        List<DailyReport> reports = service.getAllReports();
        model.addAttribute("reports", reports);
        return "report-list";
    }

    @GetMapping("/reports/{id}")
    public String showReportDetail(@PathVariable Long id, Model model) {
        DailyReport report = service.getReportById(id).orElse(null);
        model.addAttribute("report", report);
        return "report-detail";
    }
}

