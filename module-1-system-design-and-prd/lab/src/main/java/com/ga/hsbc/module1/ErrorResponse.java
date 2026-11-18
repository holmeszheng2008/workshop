package com.ga.hsbc.module1;

public record ErrorResponse(String code, String message) {
    public ErrorResponse {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("code must not be null or blank");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("message must not be null or blank");
        }
    }
}
