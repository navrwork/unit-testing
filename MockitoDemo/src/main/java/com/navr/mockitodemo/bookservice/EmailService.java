package com.navr.mockitodemo.bookservice;

public interface EmailService {

    void sendEmailToMember(String memberEmailId, String message);

    void sendReturnReminder(String memberEmailId);
}
