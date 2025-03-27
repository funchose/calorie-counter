package com.systems.caloriecounter.controller;

import com.systems.caloriecounter.DTO.request.CreateMealRequest;
import com.systems.caloriecounter.DTO.request.EditMealRequest;
import com.systems.caloriecounter.DTO.response.CreateMealResponse;
import com.systems.caloriecounter.DTO.response.DeleteMealResponse;
import com.systems.caloriecounter.DTO.response.EditMealResponse;
import com.systems.caloriecounter.service.MealService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MealController {

  private final MealService mealService;

  public MealController(MealService mealService) {
    this.mealService = mealService;
  }

  @PostMapping("/meals")
  public CreateMealResponse createMeal(@RequestBody CreateMealRequest request) {
    return mealService.createMeal(request);
  }

  @PutMapping("/meals/{mealId}")
  public EditMealResponse editMeal(@PathVariable Long mealId,
                                   @RequestBody EditMealRequest request) {
    return mealService.editMeal(mealId, request);
  }

  @DeleteMapping("/meals/{mealId}")
  public DeleteMealResponse deleteMeal(@PathVariable Long mealId) {
    return mealService.deleteMeal(mealId);
  }
}
