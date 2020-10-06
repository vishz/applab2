package com.ceyentra.applab.dto;

public class ErrorMessageResponse {

    private boolean success;
    private String message;

    public ErrorMessageResponse() {
    }

    public ErrorMessageResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
