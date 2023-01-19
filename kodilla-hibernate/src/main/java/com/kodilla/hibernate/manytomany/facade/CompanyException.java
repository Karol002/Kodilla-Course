package com.kodilla.hibernate.manytomany.facade;

public class CompanyException extends Exception {

    public static String COMPANY_NOT_FOUND = "Company not found";

    public CompanyException(String message) {
        super(message);
    }
}
