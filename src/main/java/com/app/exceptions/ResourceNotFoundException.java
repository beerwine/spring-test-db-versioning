package com.app.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        this("Resource not found.");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
