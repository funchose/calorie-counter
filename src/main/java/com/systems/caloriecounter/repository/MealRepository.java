package com.systems.caloriecounter.repository;

import com.systems.caloriecounter.model.Meal;
import com.systems.caloriecounter.model.Profile;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MealRepository extends JpaRepository<Meal, Long> {
  List<Meal> findMealsByProfileIdAndMealDateBetween(Long profileId, Date fromDate, Date toDate);
  List<Meal> findMealsByProfileIdAndMealDate(Long profileId, Date date);

  @Query("""
      SELECT SUM(d.calories) FROM Meal m
      JOIN m.dishes d
      WHERE m.profile = :profile
      AND m.mealDate = :date
      """)
  Integer countCaloriesSum(Profile profile, Date date);
}
