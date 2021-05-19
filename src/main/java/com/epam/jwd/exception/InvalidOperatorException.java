package com.epam.jwd.exception;

public class InvalidOperatorException extends Exception {

    private final String operator;

    public InvalidOperatorException(String operator) {
        this.operator = operator;
    }

    @Override
    public String getMessage() {
        return "Invalid operator: " + operator;
    }
}
