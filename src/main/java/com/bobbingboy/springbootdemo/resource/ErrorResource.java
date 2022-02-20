package com.bobbingboy.springbootdemo.resource;

public class ErrorResource {
    private String message;

    public String getMessage() {
        return message;
    }

    public ErrorResource(String message) {
        this.message = message;
    }
}
