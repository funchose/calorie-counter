package com.systems.caloriecounter.DTO.request;

import com.systems.caloriecounter.utils.Activity;
import com.systems.caloriecounter.utils.Gender;
import com.systems.caloriecounter.utils.Goal;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
@Schema(description = "Create profile request")
public class CreateProfileRequest {
  @Schema(description = "Name")
  @NotBlank(message = "Name is required")
  private String name;
  @Schema(description = "Email")
  @NotBlank(message = "Email is required")
  @Email
  private String email;
  @Schema(description = "Age")
  @NotNull(message = "Age is required")
  @Range(min = 10, max = 110, message = "Age should be from 10 to 110")
  private Integer age;
  @Schema(description = "Gender")
  @NotNull(message = "Gender is required")
  private Gender gender;
  @Schema(description = "Weight in kg")
  @NotNull(message = "Weight is required")
  @Range(min=25, max = 200, message = "Weight number should be from 25 to 200 kg")
  private Integer weight;
  @Schema(description = "Height in cm")
  @NotNull(message = "Height is required")
  @Range(min=100, max = 220, message = "Height number should be from 100 to 220 cm")
  private Integer height;
  @Schema(description = "Goal")
  @NotNull(message = "Goal is required")
  private Goal goal;
  @Schema(description = "Activity")
  @NotNull(message = "Activity is required")
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

  public CreateProfileRequest setName(String name) {
    this.name = name;
    return this;
  }

  public CreateProfileRequest setEmail(String email) {
    this.email = email;
    return this;
  }

  public CreateProfileRequest setAge(Integer age) {
    this.age = age;
    return this;
  }

  public CreateProfileRequest setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public CreateProfileRequest setWeight(Integer weight) {
    this.weight = weight;
    return this;
  }

  public CreateProfileRequest setHeight(Integer height) {
    this.height = height;
    return this;
  }

  public CreateProfileRequest setGoal(Goal goal) {
    this.goal = goal;
    return this;
  }

  public CreateProfileRequest setActivity(Activity activity) {
    this.activity = activity;
    return this;
  }
}
