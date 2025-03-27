package com.systems.caloriecounter.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "meal")
@SQLRestriction("is_active <> false")
public class Meal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "meal_date")
  private Date mealDate;
  @ManyToOne(fetch = FetchType.LAZY)
  private Profile profile;
  @ManyToMany
  @JoinTable(
      name = "meal_dish",
      joinColumns = @JoinColumn(name = "meal_id"),
      inverseJoinColumns = @JoinColumn(name = "dish_id")
  )
  private List<Dish> dishes;
  @Column(name = "is_active")
  private boolean isActive;

  public Long getId() {
    return id;
  }

  public Date getDate() {
    return mealDate;
  }

  public Meal setMealDate(Date mealDate) {
    this.mealDate = mealDate;
    return this;
  }

  public Profile getProfile() {
    return profile;
  }

  public Meal setProfile(Profile profile) {
    this.profile = profile;
    return this;
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public Meal setDishes(List<Dish> dishes) {
    this.dishes = dishes;
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public Meal setActive(boolean active) {
    isActive = active;
    return this;
  }
}
