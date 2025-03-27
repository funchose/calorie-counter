package com.systems.caloriecounter.exceptions;

public class ProfileNotFoundException extends RuntimeException {
  public ProfileNotFoundException(Long id) {
    super(String.format("Profile with id %d not found", id));
  }
}
