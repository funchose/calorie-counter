package com.systems.caloriecounter.exceptions;

public class MealNotFoundException extends RuntimeException{
  public MealNotFoundException(Long id) {
    super(String.format("Meal with id %s not found", id));
  }
}
