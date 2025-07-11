package com.example.flowershopmanager.entity;

import java.time.LocalDate;

public class Sale {
    private LocalDate date;
    private int amount;

    // 🌟 引数ありのコンストラクタ
    public Sale(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    // ✅ 引数なしのデフォルトコンストラクタ（JPA対応用にも必要なときがある）
    public Sale() {}

    // 🌟 ゲッター
    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    // 🔧 セッター（今は不要だけど将来的に必要なら）
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}


