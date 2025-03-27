package com.systems.caloriecounter.DTO.request;

import java.sql.Date;
import java.util.List;

public class EditMealRequest {
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
}
