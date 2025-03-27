package com.systems.caloriecounter.DTO.response;

public class DeleteMealResponse {
  private Long mealId;

  public Long getMealId() {
    return mealId;
  }

  public DeleteMealResponse setMealId(Long mealId) {
    this.mealId = mealId;
    return this;
  }
}
