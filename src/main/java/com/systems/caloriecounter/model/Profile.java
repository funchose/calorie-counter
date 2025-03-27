package com.systems.caloriecounter.model;

import com.systems.caloriecounter.utils.Activity;
import com.systems.caloriecounter.utils.Gender;
import com.systems.caloriecounter.utils.Goal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Range;

@Entity
@SQLRestriction("is_active <> false")
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;
  @NotBlank
  @Column(length = 20)
  private String name;
  @NotBlank
  @Column(length = 50, unique = true)
  private String email;
  @NotNull
  @Range(min = 10, max = 110)
  @Column
  private Integer age;
  @Enumerated(EnumType.STRING)
  @NotNull
  @Column(length = 10)
  private Gender gender;
  @NotNull
  @Range(min = 25, max = 200)
  @Column
  private Integer weight;
  @NotNull
  @Range(min = 100, max = 220)
  @Column
  private Integer height;
  @Enumerated(EnumType.STRING)
  @NotNull
  @Column(length = 15)
  private Goal goal;
  @Enumerated(EnumType.STRING)
  @NotNull
  @Column(length = 10)
  private Activity activity;
  @Column(name = "calorie_norm")
  private Integer calorieNorm;
  @Column(name = "is_active")
  boolean isActive;

  public Profile() {
  }

  public Activity getActivity() {
    return activity;
  }

  public Profile setActivity(Activity activity) {
    this.activity = activity;
    return this;
  }

  public Long getId() {
    return id;
  }

  public Profile setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Profile setName(String name) {
    this.name = name;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Profile setEmail(String email) {
    this.email = email;
    return this;
  }

  public int getAge() {
    return age;
  }

  public Profile setAge(int age) {
    this.age = age;
    return this;
  }

  public Gender getGender() {
    return gender;
  }

  public Profile setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public int getWeight() {
    return weight;
  }

  public Profile setWeight(int weight) {
    this.weight = weight;
    return this;
  }

  public int getHeight() {
    return height;
  }

  public Profile setHeight(int height) {
    this.height = height;
    return this;
  }

  public Goal getGoal() {
    return goal;
  }

  public Profile setGoal(Goal goal) {
    this.goal = goal;
    return this;
  }

  public Profile setCalorieNorm(Integer calorieNorm) {
    this.calorieNorm = calorieNorm;
    return this;
  }

  public Integer getCalorieNorm() {
    return calorieNorm;
  }

  public Profile setActive(boolean active) {
    isActive = active;
    return this;
  }
}
