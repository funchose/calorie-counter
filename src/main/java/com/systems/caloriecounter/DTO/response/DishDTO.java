package com.systems.caloriecounter.DTO.response;

import com.systems.caloriecounter.model.Dish;

public class DishDTO {
  private Long id;
  private String dish;
  private Integer calories;
  private Double proteins;
  private Double fats;
  private Double carbs;

  public DishDTO(Dish dish) {
    this.id = dish.getId();
    this.dish = dish.getDish();
    this.calories = dish.getCalories();
    this.proteins = dish.getProteins();
    this.fats = dish.getFats();
    this.carbs = dish.getCarbs();
  }

  public Long getId() {
    return id;
  }

  public DishDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public String getDish() {
    return dish;
  }

  public DishDTO setDish(String dish) {
    this.dish = dish;
    return this;
  }

  public Integer getCalories() {
    return calories;
  }

  public DishDTO setCalories(Integer calories) {
    this.calories = calories;
    return this;
  }

  public Double getProteins() {
    return proteins;
  }

  public DishDTO setProteins(Double proteins) {
    this.proteins = proteins;
    return this;
  }

  public Double getFats() {
    return fats;
  }

  public DishDTO setFats(Double fats) {
    this.fats = fats;
    return this;
  }

  public Double getCarbs() {
    return carbs;
  }

  public DishDTO setCarbs(Double carbs) {
    this.carbs = carbs;
    return this;
  }
}
