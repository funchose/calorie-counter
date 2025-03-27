package com.systems.caloriecounter.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDishRequest {
  @NotBlank(message = "Dish name cannot be blank")
  @Schema(description = "Dish name")
  private String dish;
  @Schema(description = "Kilocalories in one portion")
  @NotNull
  private Integer calories;
  @Schema(description = "Grams of proteins in one portion")
  @NotNull
  private Double proteins;
  @Schema(description = "Grams of fats in one portion")
  @NotNull
  private Double fats;
  @Schema(description = "Grams of carbohydrates in one portion")
  @NotNull
  private Double carbs;

  public String getDish() {
    return dish;
  }

  public Integer getCalories() {
    return calories;
  }

  public Double getProteins() {
    return proteins;
  }

  public Double getFats() {
    return fats;
  }

  public Double getCarbs() {
    return carbs;
  }

  public CreateDishRequest setDish(String dish) {
    this.dish = dish;
    return this;
  }

  public CreateDishRequest setCalories(Integer calories) {
    this.calories = calories;
    return this;
  }

  public CreateDishRequest setProteins(Double proteins) {
    this.proteins = proteins;
    return this;
  }

  public CreateDishRequest setFats(Double fats) {
    this.fats = fats;
    return this;
  }

  public CreateDishRequest setCarbs(Double carbs) {
    this.carbs = carbs;
    return this;
  }
}
