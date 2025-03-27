package com.systems.caloriecounter.DTO.response;

import com.systems.caloriecounter.model.Dish;
import com.systems.caloriecounter.model.Meal;
import java.util.List;

public class MealReportDTO {
  private Long id;
  private List<Dish> dishes;

  public MealReportDTO(Meal meal) {
    this.id = meal.getId();
    this.dishes = meal.getDishes();
  }

  public Long getId() {
    return id;
  }

  public MealReportDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public MealReportDTO setDishes(List<Dish> dishes) {
    this.dishes = dishes;
    return this;
  }
}
