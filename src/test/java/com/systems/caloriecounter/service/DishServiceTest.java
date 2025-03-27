package com.systems.caloriecounter.service;

import com.systems.caloriecounter.CalorieCounterApplication;
import com.systems.caloriecounter.DTO.request.CreateDishRequest;
import com.systems.caloriecounter.repository.DishRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalorieCounterApplication.class)
public class DishServiceTest {
  @Autowired
  private DishRepository dishRepository;
  @Autowired
  private DishService dishService;

  @Transactional
  @Test
  public void addDishTest() {
    var dish = new CreateDishRequest()
        .setDish("porridge")
        .setCalories(71)
        .setFats(1.5)
        .setProteins(2.5)
        .setCarbs(10.3);
    var dishId = dishService.createDish(dish).getId();
    Assertions.assertEquals(1, dishId);
  }
}
