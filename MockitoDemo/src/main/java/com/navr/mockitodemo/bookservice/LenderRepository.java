package com.navr.mockitodemo.bookservice;

public interface LenderRepository {

    Lender findByLenderId(String lenderId);

}
