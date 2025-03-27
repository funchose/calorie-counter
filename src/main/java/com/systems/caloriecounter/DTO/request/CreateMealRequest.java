package com.systems.caloriecounter.DTO.request;

import java.sql.Date;
import java.util.List;

public class CreateMealRequest {
  private Long profileId;
  private Date mealDate;
  private List<Long> dishIds;

  public Long getProfileId() {
    return profileId;
  }

  public Date getMealDate() {
    return mealDate;
  }

  public List<Long> getDishIds() {
    return dishIds;
  }

  public CreateMealRequest setProfileId(Long profileId) {
    this.profileId = profileId;
    return this;
  }

  public CreateMealRequest setMealDate(Date mealDate) {
    this.mealDate = mealDate;
    return this;
  }

  public CreateMealRequest setDishIds(List<Long> dishIds) {
    this.dishIds = dishIds;
    return this;
  }
}
