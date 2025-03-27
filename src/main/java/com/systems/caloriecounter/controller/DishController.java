package com.systems.caloriecounter.controller;

import com.systems.caloriecounter.DTO.request.CreateDishRequest;
import com.systems.caloriecounter.DTO.request.EditDishRequest;
import com.systems.caloriecounter.DTO.response.CreateDishResponse;
import com.systems.caloriecounter.DTO.response.DeleteDishResponse;
import com.systems.caloriecounter.DTO.response.DishDTO;
import com.systems.caloriecounter.DTO.response.EditDishResponse;
import com.systems.caloriecounter.service.DishService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DishController {
  private final DishService dishService;

  public DishController(DishService dishService) {
    this.dishService = dishService;
  }

  @GetMapping("/dishes")
  public List<DishDTO> getDishes() {
    return dishService.getDishes();
  }

  @PostMapping("/dishes")
  public CreateDishResponse createDish(@RequestBody CreateDishRequest request) {
    return dishService.createDish(request);
  }

  @PutMapping("/dishes/{dishId}")
  public EditDishResponse editDish(@PathVariable Long dishId,
                                   @RequestBody EditDishRequest request) {
    return dishService.editDish(dishId, request);
  }

  @DeleteMapping("/dishes/{dishId}")
  public DeleteDishResponse deleteDish(@PathVariable Long dishId) {
    return dishService.deleteDish(dishId);
  }
}
