package com.systems.caloriecounter.service;

import com.systems.caloriecounter.CalorieCounterApplication;
import com.systems.caloriecounter.DTO.request.CreateDishRequest;
import com.systems.caloriecounter.DTO.request.CreateMealRequest;
import com.systems.caloriecounter.DTO.request.CreateProfileRequest;
import com.systems.caloriecounter.utils.Activity;
import com.systems.caloriecounter.utils.Gender;
import com.systems.caloriecounter.utils.Goal;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalorieCounterApplication.class)
public class MealServiceTest {
  @Autowired
  private ProfileService profileService;
  @Autowired
  private DishService dishService;
  @Autowired
  private MealService mealService;

  @Test
  public void addMealTest() {
    var dish = new CreateDishRequest()
        .setDish("porridge")
        .setCalories(71)
        .setFats(1.5)
        .setProteins(2.5)
        .setCarbs(10.3);
    var dishId = dishService.createDish(dish).getId();
    var request = new CreateProfileRequest()
        .setName("Ivan")
        .setAge(40)
        .setHeight(180)
        .setWeight(70)
        .setEmail("ivan@mail.ru")
        .setGender(Gender.MALE)
        .setActivity(Activity.HIGH)
        .setGoal(Goal.KEEP_WEIGHT);
    var profileId = profileService.addProfile(request).getId();
    var idsList = new ArrayList<Long>();
    idsList.add(dishId);
    var meal = new CreateMealRequest()
        .setProfileId(profileId)
        .setMealDate(new java.sql.Date(new java.util.Date().getTime()))
        .setDishIds(idsList);
    var createdMeal = mealService.createMeal(meal);
    Assertions.assertEquals(1L, createdMeal.getMealId());
  }
}
