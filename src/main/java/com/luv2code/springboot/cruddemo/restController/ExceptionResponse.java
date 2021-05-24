package com.luv2code.springboot.cruddemo.restController;

public class ExceptionResponse {
    private int statusCode;
    private String message;
    private long timeStamp;

    public ExceptionResponse(int statusCode, String message, long timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public ExceptionResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
