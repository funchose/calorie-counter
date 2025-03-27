package com.systems.caloriecounter.utils;

import com.systems.caloriecounter.model.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalorieCalculatorTest {

  @Test
  public void calculateWomenCaloriesRateTest() {
    var profile = new Profile()
        .setGender(Gender.FEMALE)
        .setAge(35)
        .setActivity(Activity.HIGH)
        .setHeight(170)
        .setWeight(65)
        .setGoal(Goal.KEEP_WEIGHT);
    Assertions.assertEquals(2453.0, CalorieCalculator.calculateCaloriesRate(profile));
  }

  @Test
  public void calculateMenCaloriesRateTest() {
    var profile = new Profile()
        .setGender(Gender.MALE)
        .setAge(30)
        .setActivity(Activity.LOW)
        .setHeight(180)
        .setWeight(90)
        .setGoal(Goal.LOSE_WEIGHT);
    Assertions.assertEquals(2733.0, CalorieCalculator.calculateCaloriesRate(profile));
  }
}
