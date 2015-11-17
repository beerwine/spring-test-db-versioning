package com.app.web.dto;

public class ErrorResponseDto {
    private String description;

    public ErrorResponseDto(String description) {
        this.description = description;
    }

    public ErrorResponseDto(Throwable throwable) {
        this(throwable.getMessage());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
