package com.company.exeptions;

public class NoSuchCustomerException extends Exception {

    public NoSuchCustomerException(String message) {
        super(message);
    }
}
