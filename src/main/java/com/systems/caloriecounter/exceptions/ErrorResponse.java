package com.systems.caloriecounter.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String message) {
}