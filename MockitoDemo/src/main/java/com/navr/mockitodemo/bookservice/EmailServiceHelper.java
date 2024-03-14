package com.navr.mockitodemo.bookservice;

public class EmailServiceHelper {
    EmailService emailService;

    public EmailServiceHelper(EmailService emailService) {
        this.emailService = emailService;
    }

    private void invokeEmailService() {
        //
    }

    public static void initEmailService() {
        System.out.println("Inside initEmailService ..");
    }

    public static String name() {
        return "_EmailServiceHelper";
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String getUpdatedEmailAddress(String emailStr) {
        StringBuffer updatedEmailAddress = new StringBuffer(emailStr);
        if (!emailStr.contains("@")) {
            updatedEmailAddress.append("@mycompany.com");
        }
        return updatedEmailAddress.toString();
    }

    public static String getUpdatedEmailAddress(String emailStr, String domain) {
        StringBuffer updatedEmailAddress = new StringBuffer();
        if (emailStr!=null && domain!=null) {
            updatedEmailAddress.append(emailStr).append("@").append(domain);
        }
        return updatedEmailAddress.toString();
    }
}
