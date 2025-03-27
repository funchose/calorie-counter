package com.systems.caloriecounter.DTO.response;

public class EditProfileResponse {
  private Long id;
  private String name;
  private Integer calorieNorm;

  public Long getId() {
    return id;
  }

  public EditProfileResponse setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public EditProfileResponse setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getCalorieNorm() {
    return calorieNorm;
  }

  public EditProfileResponse setCalorieNorm(Integer calorieNorm) {
    this.calorieNorm = calorieNorm;
    return this;
  }
}
