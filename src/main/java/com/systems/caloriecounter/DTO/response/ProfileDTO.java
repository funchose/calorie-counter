package com.systems.caloriecounter.DTO.response;

import com.systems.caloriecounter.model.Profile;

public class ProfileDTO {
  private Long id;
  private String name;
  private String email;
  private Integer calorieNorm;

  public ProfileDTO(Profile profile) {
    this.id = profile.getId();
    this.name = profile.getName();
    this.email = profile.getEmail();
    this.calorieNorm = profile.getCalorieNorm();
  }

  public Long getId() {
    return id;
  }

  public ProfileDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public ProfileDTO setName(String name) {
    this.name = name;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public ProfileDTO setEmail(String email) {
    this.email = email;
    return this;
  }

  public Integer getCalorieNorm() {
    return calorieNorm;
  }

  public ProfileDTO setCalorieNorm(Integer calorieNorm) {
    this.calorieNorm = calorieNorm;
    return this;
  }
}
