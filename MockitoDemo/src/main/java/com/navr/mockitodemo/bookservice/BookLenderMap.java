package com.navr.mockitodemo.bookservice;

import java.time.LocalDate;

public class BookLenderMap {
    private String bookId;

    private String lenderId;

    private LocalDate lendStartDate;

    private LocalDate lendEndDate;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public LocalDate getLendStartDate() {
        return lendStartDate;
    }

    public void setLendStartDate(LocalDate lendStartDate) {
        this.lendStartDate = lendStartDate;
    }

    public LocalDate getLendEndDate() {
        return lendEndDate;
    }

    public void setLendEndDate(LocalDate lendEndDate) {
        this.lendEndDate = lendEndDate;
    }
}
