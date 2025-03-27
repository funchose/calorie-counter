package com.systems.caloriecounter.DTO.response;

public class DeleteDishResponse {
  private Long dishId;

  public Long getDishId() {
    return dishId;
  }

  public DeleteDishResponse setDishId(Long dishId) {
    this.dishId = dishId;
    return this;
  }
}
