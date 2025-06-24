package com.example.flowershopmanager.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DailyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Lob
    private String content;

    // getter / setter
}
