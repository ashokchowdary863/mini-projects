package com.ashok.exception;

public class AppException extends Exception{
    private AppError error;

    public AppException() {
        super();
    }

    public AppException(AppError error, String message, Object... arguments) {
        super(String.format(message, arguments));
    }

    public AppException(String message, Throwable cause, Object... arguments) {
        super(String.format(message, arguments), cause);
    }

    public AppError getError() {
        return error;
    }

    public void setError(AppError error) {
        this.error = error;
    }
}
