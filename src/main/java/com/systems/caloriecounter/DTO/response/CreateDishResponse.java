package com.systems.caloriecounter.DTO.response;

public class CreateDishResponse {
  private Long id;
  private String dish;
  private Integer calories;
  private Double proteins;
  private Double fats;
  private Double carbs;

  public Long getId() {
    return id;
  }

  public CreateDishResponse setId(Long id) {
    this.id = id;
    return this;
  }

  public String getDish() {
    return dish;
  }

  public CreateDishResponse setDish(String dish) {
    this.dish = dish;
    return this;
  }

  public Integer getCalories() {
    return calories;
  }

  public CreateDishResponse setCalories(Integer calories) {
    this.calories = calories;
    return this;
  }

  public Double getProteins() {
    return proteins;
  }

  public CreateDishResponse setProteins(Double proteins) {
    this.proteins = proteins;
    return this;
  }

  public Double getFats() {
    return fats;
  }

  public CreateDishResponse setFats(Double fats) {
    this.fats = fats;
    return this;
  }

  public Double getCarbs() {
    return carbs;
  }

  public CreateDishResponse setCarbs(Double carbs) {
    this.carbs = carbs;
    return this;
  }
}
