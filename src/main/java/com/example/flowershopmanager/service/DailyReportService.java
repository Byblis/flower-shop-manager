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

    public void saveReport(String content) {
        DailyReport report = new DailyReport();
        report.setDate(LocalDate.now());
        report.setContent(content);
        repository.save(report);
    }

    public List<DailyReport> getAllReports() {
        return repository.findAll();
    }

    public Optional<DailyReport> getReportById(Long id) {
        return repository.findById(id);
    }
}

