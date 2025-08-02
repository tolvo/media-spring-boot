package com.pedro.media.media_manager.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private LocalDate startReadDate;
    private LocalDate endReadDate;
    private Double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getStartReadDate() {
        return startReadDate;
    }

    public void setStartReadDate(LocalDate startReadDate) {
        this.startReadDate = startReadDate;
    }

    public LocalDate getEndReadDate() {
        return endReadDate;
    }

    public void setEndReadDate(LocalDate endReadDate) {
        this.endReadDate = endReadDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}