package com.java.restaurant_review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.restaurant_review.dto.RestaurantDto;
import com.java.restaurant_review.entity.Restaurant;
import com.java.restaurant_review.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired private RestaurantService restaurantService;

    @PostMapping
    public Restaurant create(@RequestBody @Valid RestaurantDto dto) {
        return restaurantService.create(dto);
    }

    @GetMapping("/{id}/average-rating")
    public Double averageRating(@PathVariable Long id) {
        return restaurantService.getAverageRating(id);
    }

    @GetMapping("/top3")
    public List<Restaurant> top3(@RequestParam String cuisineType) {
        return restaurantService.top3ByCuisine(cuisineType);
    }
}

