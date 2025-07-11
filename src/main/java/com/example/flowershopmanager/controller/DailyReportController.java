package com.example.flowershopmanager.controller;

import com.example.flowershopmanager.entity.DailyReport;
import com.example.flowershopmanager.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DailyReportController {

    @Autowired
    private DailyReportService service;

    @PostMapping("/dashboard/operations/submitReport")
    public String submitReport(
            @RequestParam("reportDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportDate,
            @RequestParam("report") String reportContent,
            Model model) {
        service.saveReport(reportDate, reportContent);
        model.addAttribute("message", "日報が保存されました！");
        return "operations-closing";
    }

    @PostMapping("/reports/delete/{id}")
public String deleteReport(@PathVariable Long id) {
    service.deleteReportById(id);
    return "redirect:/reports";
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


