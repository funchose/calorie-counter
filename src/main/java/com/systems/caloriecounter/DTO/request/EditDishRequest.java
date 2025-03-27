package com.systems.caloriecounter.DTO.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class EditDishRequest {
  @Schema(description = "Dish name")
  private String dish;
  @Schema(description = "Kilocalories in one portion")
  private Integer calories;
  @Schema(description = "Grams of proteins in one portion")
  private Double proteins;
  @Schema(description = "Grams of fats in one portion")
  private Double fats;
  @Schema(description = "Grams of carbohydrates in one portion")
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
}
