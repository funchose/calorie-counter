package com.systems.caloriecounter.utils;

public enum Activity {
  MINIMAL ("Absence of physical activity", 1.2F),
  LOW ("1 - 3 physical activities per week", 1.375F),
  MEDIUM ("3 - 5 physical activities per week", 1.55F),
  HIGH ("6 - 7 physical activities per week", 1.725F),
  EXTREME ("Physical activities performed more often than once per day", 1.9F);
  private final String description;
  private final float coefficient;

  Activity(String description, float coefficient) {
    this.description = description;
    this.coefficient = coefficient;
  }

  public float getCoefficient() {
    return coefficient;
  }

  public String getDescription() {
    return description;
  }
}
