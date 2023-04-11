package org.example.entities;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Contract {

    private LocalDate date;
    private Double totalValue;
    private Integer number;

    private List<Installment> installments = new ArrayList<>();

    public Contract(LocalDate date, Double totalValue, Integer number ) {
        this.date = date;
        this.totalValue = totalValue;
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Installment> getInstallments() {
        return installments;
    }
}
