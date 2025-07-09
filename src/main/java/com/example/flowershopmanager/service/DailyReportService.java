package com.example.flowershopmanager.service;

import com.example.flowershopmanager.entity.DailyReport;
import com.example.flowershopmanager.repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DailyReportService {

    @Autowired
    private DailyReportRepository repository;

    // 修正後（OK）
public void saveReport(LocalDate date, String content) {
    DailyReport report = new DailyReport();
    report.setDate(date); // ← フォームから受け取った日付を使う！
    report.setContent(content);
    repository.save(report);
}

    public List<DailyReport> getAllReports() {
        return repository.findAll();
    }

    public Optional<DailyReport> getReportById(Long id) {
        return repository.findById(id);
    }

    public void deleteReportById(Long id) {
    repository.deleteById(id);
}

}

