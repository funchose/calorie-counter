package com.systems.caloriecounter.repository;

import com.systems.caloriecounter.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {

}
