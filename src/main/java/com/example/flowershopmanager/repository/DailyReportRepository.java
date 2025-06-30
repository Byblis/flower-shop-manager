package com.example.flowershopmanager.repository;

import com.example.flowershopmanager.entity.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
    
    // 日付で日報を検索する（※今後使いたいときのため）
    Optional<DailyReport> findByDate(LocalDate date);
}
