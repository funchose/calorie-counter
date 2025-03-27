package com.systems.caloriecounter.utils;

import com.systems.caloriecounter.model.Profile;

public class CalorieCalculator {
  private static final float MEN_FIRST_TERM = 88.36F;
  private static final float WOMEN_FIRST_TERM = 447.6F;
  private static final float MEN_WEIGHT_COEFFICIENT = 13.4F;
  private static final float WOMEN_WEIGHT_COEFFICIENT = 9.2F;
  private static final float MEN_HEIGHT_COEFFICIENT = 4.8F;
  private static final float WOMEN_HEIGHT_COEFFICIENT = 3.1F;
  private static final float MEN_AGE_COEFFICIENT = 5.7F;
  private static final float WOMEN_AGE_COEFFICIENT = 4.3F;


  public static int calculateCaloriesRate(Profile profile) {
    return switch (profile.getGender()) {
      case Gender.MALE ->
          Math.round((MEN_FIRST_TERM + MEN_WEIGHT_COEFFICIENT * profile.getWeight()
          + MEN_HEIGHT_COEFFICIENT * profile.getHeight()
          - MEN_AGE_COEFFICIENT * profile.getAge())
          * profile.getActivity().getCoefficient());
      case Gender.FEMALE ->
          Math.round((WOMEN_FIRST_TERM + WOMEN_WEIGHT_COEFFICIENT * profile.getWeight()
          + WOMEN_HEIGHT_COEFFICIENT * profile.getHeight()
          - WOMEN_AGE_COEFFICIENT * profile.getAge())
          * profile.getActivity().getCoefficient());
    };
  }

}
