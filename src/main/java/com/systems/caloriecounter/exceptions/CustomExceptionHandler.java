package com.systems.caloriecounter.exceptions;

import io.swagger.v3.oas.annotations.Hidden;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Hidden
@ControllerAdvice
public class CustomExceptionHandler {
  @ExceptionHandler({ProfileNotFoundException.class})
  public ResponseEntity<Object> handleProfileNotFoundException(
      ProfileNotFoundException ex) {
    ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }
  @ExceptionHandler({MealNotFoundException.class})
  public ResponseEntity<Object> handleMealNotFoundException(
      MealNotFoundException ex) {
    ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }
  @ExceptionHandler({DishNotFoundException.class})
  public ResponseEntity<Object> handleDishNotFoundException(
      DishNotFoundException ex) {
    ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }
  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ResponseEntity<Object> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    Map<String, List<String>> body = new HashMap<>();
    List<String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .toList();
    body.put("errors", errors);
    return new ResponseEntity<>(
        body, new HttpHeaders(), errorResponse.status());
  }
  @ExceptionHandler({HttpMessageNotReadableException.class})
  public ResponseEntity<Object> handleHttpMessageNotReadableException(
      RuntimeException ex) {
    ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<Object> handleRuntimeException(
      RuntimeException ex) {
    ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
