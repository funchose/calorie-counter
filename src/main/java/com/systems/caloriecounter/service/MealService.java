package com.systems.caloriecounter.service;

import com.systems.caloriecounter.DTO.request.CreateMealRequest;
import com.systems.caloriecounter.DTO.request.EditMealRequest;
import com.systems.caloriecounter.DTO.response.CreateMealResponse;
import com.systems.caloriecounter.DTO.response.DeleteMealResponse;
import com.systems.caloriecounter.DTO.response.EditMealResponse;

public interface MealService {
  CreateMealResponse createMeal(CreateMealRequest request);

  EditMealResponse editMeal(Long mealId, EditMealRequest request);

  DeleteMealResponse deleteMeal(Long mealId);
}
