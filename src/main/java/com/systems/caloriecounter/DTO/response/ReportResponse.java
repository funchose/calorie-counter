package com.systems.caloriecounter.DTO.response;

import java.util.Date;
import java.util.List;

public class ReportResponse {
  private Long profileId;
  private String name;
  private Date date;
  private List<MealReportDTO> meals;
  private Integer calories;

  public Long getProfileId() {
    return profileId;
  }

  public ReportResponse setProfileId(Long profileId) {
    this.profileId = profileId;
    return this;
  }

  public String getName() {
    return name;
  }

  public ReportResponse setName(String name) {
    this.name = name;
    return this;
  }

  public Date getDate() {
    return date;
  }

  public ReportResponse setDate(Date date) {
    this.date = date;
    return this;
  }

  public List<MealReportDTO> getMeals() {
    return meals;
  }

  public ReportResponse setMeals(List<MealReportDTO> meals) {
    this.meals = meals;
    return this;
  }

  public Integer getCalories() {
    return calories;
  }

  public ReportResponse setCalories(Integer calories) {
    this.calories = calories;
    return this;
  }
}
