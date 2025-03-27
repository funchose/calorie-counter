package com.systems.caloriecounter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLRestriction("is_active <> false")
public class Dish {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Column(unique = true)
  private String dish;
  @NotNull
  private Integer calories;
  @NotNull
  private Double proteins;
  @NotNull
  private Double fats;
  @NotNull
  private Double carbs;
  @ManyToMany(mappedBy = "dishes")
  private List<Meal> meals;
  @Column(name = "is_active")
  private boolean isActive;

  public String getDish() {
    return dish;
  }

  public Long getId() {
    return id;
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

  public Dish setActive(boolean active) {
    isActive = active;
    return this;
  }

  public Dish setDish(String dish) {
    this.dish = dish;
    return this;
  }

  public Dish setCalories(Integer calories) {
    this.calories = calories;
    return this;
  }

  public Dish setProteins(Double proteins) {
    this.proteins = proteins;
    return this;
  }

  public Dish setFats(Double fats) {
    this.fats = fats;
    return this;
  }

  public Dish setCarbs(Double carbs) {
    this.carbs = carbs;
    return this;
  }

  public Dish setMeals(List<Meal> meals) {
    this.meals = meals;
    return this;
  }
}
