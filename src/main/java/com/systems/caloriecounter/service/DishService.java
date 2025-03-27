package com.systems.caloriecounter.service;

import com.systems.caloriecounter.DTO.request.CreateDishRequest;
import com.systems.caloriecounter.DTO.request.EditDishRequest;
import com.systems.caloriecounter.DTO.response.CreateDishResponse;
import com.systems.caloriecounter.DTO.response.DeleteDishResponse;
import com.systems.caloriecounter.DTO.response.DishDTO;
import com.systems.caloriecounter.DTO.response.EditDishResponse;
import java.util.List;

public interface DishService {
  List<DishDTO> getDishes();

  DeleteDishResponse deleteDish(Long dishId);

  CreateDishResponse createDish(CreateDishRequest request);

  EditDishResponse editDish(Long dishId, EditDishRequest request);
}

