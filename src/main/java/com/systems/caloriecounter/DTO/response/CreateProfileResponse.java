package com.systems.caloriecounter.DTO.response;

public class CreateProfileResponse {
  private Long id;
  private String name;
  private Integer calorieNorm;

  public Long getId() {
    return id;
  }

  public CreateProfileResponse setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public CreateProfileResponse setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getCalorieNorm() {
    return calorieNorm;
  }

  public CreateProfileResponse setCalorieNorm(Integer calorieNorm) {
    this.calorieNorm = calorieNorm;
    return this;
  }
}
