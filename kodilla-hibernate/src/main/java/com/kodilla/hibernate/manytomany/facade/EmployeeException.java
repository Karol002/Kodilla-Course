package com.kodilla.hibernate.manytomany.facade;

public class EmployeeException extends  Exception {

    public static String EMPLOYEE_NOT_FOUND = "Employee not found";

    public EmployeeException(String message) {
        super(message);
    }
}
