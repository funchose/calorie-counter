package com.systems.caloriecounter.DTO.response;

import java.util.List;

public class CreateMealResponse {
  private Long mealId;
  private Long profileId;
  private List<String> dishNames;

  public CreateMealResponse setMealId(Long mealId) {
    this.mealId = mealId;
    return this;
  }

  public CreateMealResponse setProfileId(Long profileId) {
    this.profileId = profileId;
    return this;
  }

  public CreateMealResponse setDishNames(List<String> dishNames) {
    this.dishNames = dishNames;
    return this;
  }

  public Long getMealId() {
    return mealId;
  }

  public Long getProfileId() {
    return profileId;
  }

  public List<String> getDishNames() {
    return dishNames;
  }
}
