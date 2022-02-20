package com.bobbingboy.springbootdemo.resource;

public class InvalidErrorResource {
    private String massage;
    private Object errors;

    public InvalidErrorResource(String massage, Object errors) {
        this.massage = massage;
        this.errors = errors;
    }

    public String getMassage() {
        return massage;
    }

    public Object getErrors() {
        return errors;
    }
}
