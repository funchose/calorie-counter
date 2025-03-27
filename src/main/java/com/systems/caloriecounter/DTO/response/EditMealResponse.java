package com.systems.caloriecounter.DTO.response;

import java.util.List;

public class EditMealResponse {
  private Long mealId;
  private Long profileId;
  private List<String> dishNames;

  public EditMealResponse setMealId(Long mealId) {
    this.mealId = mealId;
    return this;
  }

  public EditMealResponse setProfileId(Long profileId) {
    this.profileId = profileId;
    return this;
  }

  public EditMealResponse setDishNames(List<String> dishNames) {
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
