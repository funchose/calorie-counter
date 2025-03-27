package com.systems.caloriecounter.DTO.response;

import java.sql.Date;

public class CheckResponse {
  private Long profileId;
  private String name;
  private Date date;
  private String response;
  private int calorieNorm;
  private int currentCalories;

  public Date getDate() {
    return date;
  }

  public CheckResponse setDate(Date date) {
    this.date = date;
    return this;
  }

  public Long getProfileId() {
    return profileId;
  }

  public CheckResponse setProfileId(Long profileId) {
    this.profileId = profileId;
    return this;
  }

  public String getName() {
    return name;
  }

  public CheckResponse setName(String name) {
    this.name = name;
    return this;
  }

  public String getResponse() {
    return response;
  }

  public CheckResponse setResponse(String response) {
    this.response = response;
    return this;
  }

  public int getCalorieNorm() {
    return calorieNorm;
  }

  public CheckResponse setCalorieNorm(int calorieNorm) {
    this.calorieNorm = calorieNorm;
    return this;
  }

  public int getCurrentCalories() {
    return currentCalories;
  }

  public CheckResponse setCurrentCalories(int currentCalories) {
    this.currentCalories = currentCalories;
    return this;
  }
}
