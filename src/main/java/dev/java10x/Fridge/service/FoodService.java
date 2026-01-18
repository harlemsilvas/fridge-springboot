// src/main/java/dev/java10x/Fridge/service/FoodService.java
package dev.java10x.Fridge.service;

import dev.java10x.Fridge.model.Food;
import dev.java10x.Fridge.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public void delete(Long id) {
        foodRepository.deleteById(id);
    }

    public Optional<Food> findById(Long id) {
        return foodRepository.findById(id);
    }

    public Food update(Long id, Food foodDetails) {
        Food existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));

        existingFood.setName(foodDetails.getName());
        existingFood.setExpirationDate(foodDetails.getExpirationDate());
        existingFood.setQuantity(foodDetails.getQuantity());

        return foodRepository.save(existingFood);
    }
}