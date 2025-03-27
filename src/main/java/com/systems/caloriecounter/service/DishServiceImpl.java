package com.systems.caloriecounter.service;

import com.systems.caloriecounter.DTO.request.CreateDishRequest;
import com.systems.caloriecounter.DTO.request.EditDishRequest;
import com.systems.caloriecounter.DTO.response.*;
import com.systems.caloriecounter.exceptions.DishNotFoundException;
import com.systems.caloriecounter.exceptions.MealNotFoundException;
import com.systems.caloriecounter.model.Dish;
import com.systems.caloriecounter.repository.DishRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DishServiceImpl implements DishService {
  private final DishRepository dishRepository;

  public DishServiceImpl(DishRepository dishRepository) {
    this.dishRepository = dishRepository;
  }

  @Transactional
  @Override
  public List<DishDTO> getDishes() {
    return dishRepository.findAll().stream().map(DishDTO::new).toList();
  }

  @Transactional
  @Override
  public DeleteDishResponse deleteDish(Long dishId) {
    var dishToDelete = dishRepository.findById(dishId)
        .orElseThrow(() -> new MealNotFoundException(dishId));
    dishToDelete.setActive(false);
    dishRepository.save(dishToDelete);
    return new DeleteDishResponse().setDishId(dishId);
  }

  @Transactional
  @Override
  public CreateDishResponse createDish(CreateDishRequest request) {
    var dish = new Dish()
        .setDish(request.getDish())
        .setCalories(request.getCalories())
        .setCarbs(request.getCarbs())
        .setFats(request.getFats())
        .setProteins(request.getProteins())
        .setActive(true);
    var savedDish = dishRepository.save(dish);
    return new CreateDishResponse().setId(savedDish.getId())
        .setDish(savedDish.getDish())
        .setCalories(savedDish.getCalories())
        .setCarbs(savedDish.getCarbs())
        .setFats(savedDish.getFats())
        .setProteins(savedDish.getProteins());
  }

  @Transactional
  @Override
  public EditDishResponse editDish(Long dishId, EditDishRequest request) {
    var dish = dishRepository.findById(dishId).orElseThrow(() -> new DishNotFoundException(dishId));
    if (request.getDish() != null) {
      dish.setDish(request.getDish());
    }
    if (request.getCalories() != null) {
      dish.setCalories(request.getCalories());
    }
    if (request.getFats() != null) {
      dish.setFats(request.getFats());
    }
    if (request.getProteins() != null) {
      dish.setProteins(request.getProteins());
    }
    if (request.getCarbs() != null) {
      dish.setCarbs(request.getCarbs());
    }
    var editedDish = dishRepository.save(dish);
    return new EditDishResponse()
        .setId(editedDish.getId())
        .setDish(editedDish.getDish())
        .setCalories(editedDish.getCalories())
        .setCarbs(editedDish.getCarbs())
        .setFats(editedDish.getFats())
        .setProteins(editedDish.getProteins());
  }
}
