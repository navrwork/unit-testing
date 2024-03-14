package com.navr.mockitodemo.bookservice;

public class Lender {

    private String lenderId;
    private String lenderName;
    private String lenderEmail;

    private String lenderMembership;

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public String getLenderName() {
        return lenderName;
    }

    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }

    public String getLenderEmail() {
        return lenderEmail;
    }

    public void setLenderEmail(String lenderEmail) {
        this.lenderEmail = lenderEmail;
    }

    public String getLenderMembership() {
        return lenderMembership;
    }

    public void setLenderMembership(String lenderMembership) {
        this.lenderMembership = lenderMembership;
    }
}
