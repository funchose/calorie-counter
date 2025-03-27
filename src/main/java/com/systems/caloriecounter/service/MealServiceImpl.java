package com.systems.caloriecounter.service;

import com.systems.caloriecounter.DTO.request.CreateMealRequest;
import com.systems.caloriecounter.DTO.request.EditMealRequest;
import com.systems.caloriecounter.DTO.response.CreateMealResponse;
import com.systems.caloriecounter.DTO.response.DeleteMealResponse;
import com.systems.caloriecounter.DTO.response.EditMealResponse;
import com.systems.caloriecounter.exceptions.DishNotFoundException;
import com.systems.caloriecounter.exceptions.MealNotFoundException;
import com.systems.caloriecounter.exceptions.ProfileNotFoundException;
import com.systems.caloriecounter.model.Dish;
import com.systems.caloriecounter.model.Meal;
import com.systems.caloriecounter.repository.DishRepository;
import com.systems.caloriecounter.repository.MealRepository;
import com.systems.caloriecounter.repository.ProfileRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MealServiceImpl implements MealService{
    private final ProfileRepository profileRepository;
    private final MealRepository mealRepository;
    private final DishRepository dishRepository;

  public MealServiceImpl(ProfileRepository profileRepository, MealRepository mealRepository, DishRepository dishRepository) {
    this.profileRepository = profileRepository;
    this.mealRepository = mealRepository;
    this.dishRepository = dishRepository;
  }

  @Transactional
  @Override
  public CreateMealResponse createMeal(CreateMealRequest request) {
    var profile = profileRepository.findById(request.getProfileId())
        .orElseThrow(() -> new ProfileNotFoundException(request.getProfileId()));
    var dishes = new ArrayList<Dish>();
    for (Long dishId : request.getDishIds()) {
      dishes.add(dishRepository.findById(dishId)
          .orElseThrow(() -> new DishNotFoundException(dishId)));
    }
    var meal = new Meal()
        .setProfile(profile)
        .setMealDate(request.getMealDate())
        .setDishes(dishes)
        .setActive(true);
    var savedMeal = mealRepository.save(meal);
    return new CreateMealResponse()
        .setMealId(savedMeal.getId())
        .setDishNames(dishes.stream().map(Dish::getDish).toList())
        .setProfileId(profile.getId());
  }

  @Transactional
  @Override
  public EditMealResponse editMeal(Long mealId, EditMealRequest request) {
    var meal = mealRepository.findById(mealId).orElseThrow(() -> new MealNotFoundException(mealId));
    if (request.getProfileId() != null) {
      var profile = profileRepository.findById(request.getProfileId())
          .orElseThrow(() -> new ProfileNotFoundException(request.getProfileId()));
      meal.setProfile(profile);
    }
    if (request.getDishIds() != null) {
      var dishes = new ArrayList<Dish>();
      for (Long dishId : request.getDishIds()) {
        dishes.add(dishRepository.findById(dishId)
            .orElseThrow(() -> new DishNotFoundException(dishId)));
      }
      meal.setDishes(dishes);
    }
    if (request.getMealDate() != null) {
      meal.setMealDate(request.getMealDate());
    }
    var editedMeal = mealRepository.save(meal);
    return new EditMealResponse()
        .setMealId(editedMeal.getId())
        .setDishNames(editedMeal.getDishes().stream().map(Dish::getDish).toList())
        .setProfileId(editedMeal.getProfile().getId());
  }

  @Transactional
  @Override
  public DeleteMealResponse deleteMeal(Long mealId) {
    var mealToDelete = mealRepository.findById(mealId)
        .orElseThrow(() -> new MealNotFoundException(mealId));
    mealToDelete.setActive(false);
    mealRepository.save(mealToDelete);
    return new DeleteMealResponse().setMealId(mealId);
  }
}
