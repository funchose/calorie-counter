package com.systems.caloriecounter.DTO.request;

import com.systems.caloriecounter.utils.Activity;
import com.systems.caloriecounter.utils.Gender;
import com.systems.caloriecounter.utils.Goal;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Range;

public class EditProfileRequest {
  @Schema(description = "Name")
  private String name;
  @Schema(description = "Email")
  @Email
  private String email;
  @Schema(description = "Age")
  @Range(min = 10, max = 110, message = "Age should be from 10 to 110")
  private Integer age;
  @Schema(description = "Gender")
  private Gender gender;
  @Schema(description = "Weight in kg")
  @Range(min = 25, max = 200, message = "Weight number should be from 25 to 200 kg")
  private Integer weight;
  @Schema(description = "Height in cm")
  @Range(min = 100, max = 220, message = "Height number should be from 100 to 220 cm")
  private Integer height;
  @Schema(description = "Goal")
  private Goal goal;
  @Schema(description = "Activity")
  private Activity activity;

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Integer getAge() {
    return age;
  }

  public Gender getGender() {
    return gender;
  }

  public Integer getWeight() {
    return weight;
  }

  public Integer getHeight() {
    return height;
  }

  public Goal getGoal() {
    return goal;
  }

  public Activity getActivity() {
    return activity;
  }

  public EditProfileRequest setName(String name) {
    this.name = name;
    return this;
  }

  public EditProfileRequest setEmail(String email) {
    this.email = email;
    return this;
  }

  public EditProfileRequest setAge(Integer age) {
    this.age = age;
    return this;
  }

  public EditProfileRequest setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public EditProfileRequest setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  public EditProfileRequest setHeight(Integer height) {
    this.height = height;
    return this;
  }

  public EditProfileRequest setGoal(Goal goal) {
    this.goal = goal;
    return this;
  }

  public EditProfileRequest setActivity(Activity activity) {
    this.activity = activity;
    return this;
  }
}
