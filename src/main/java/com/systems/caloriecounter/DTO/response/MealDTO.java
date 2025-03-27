package com.systems.caloriecounter.DTO.response;

import com.systems.caloriecounter.model.Dish;
import com.systems.caloriecounter.model.Meal;
import java.sql.Date;
import java.util.List;

public class MealDTO {
  private Long id;
  private Date date;
  private Long profileId;
  private List<Dish> dishes;

  public MealDTO(Meal meal) {
    this.id = meal.getId();
    this.date = meal.getDate();
    this.profileId = meal.getProfile().getId();
    this.dishes = meal.getDishes();
  }

  public Long getId() {
    return id;
  }

  public MealDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public Date getDate() {
    return date;
  }

  public MealDTO setDate(Date date) {
    this.date = date;
    return this;
  }

  public Long getProfileId() {
    return profileId;
  }

  public MealDTO setProfileId(Long profileId) {
    this.profileId = profileId;
    return this;
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public MealDTO setDishes(List<Dish> dishes) {
    this.dishes = dishes;
    return this;
  }
}
