package com.java.restaurant_review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.restaurant_review.dto.RestaurantDto;
import com.java.restaurant_review.entity.Restaurant;
import com.java.restaurant_review.repository.RestaurantRepository;
import com.java.restaurant_review.repository.ReviewRepository;
import org.springframework.data.domain.PageRequest;

@Service
public class RestaurantService {
    @Autowired 
    private RestaurantRepository restaurantRepository;
    @Autowired 
    private ReviewRepository reviewRepository;

    public Restaurant create(RestaurantDto dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setCuisineType(dto.getCuisineType());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPriceRange(dto.getPriceRange());
        return restaurantRepository.save(restaurant);
    }

    public Double getAverageRating(Long restaurantId) {
        return reviewRepository.findAverageRating(restaurantId);
    }

    public List<Restaurant> top3ByCuisine(String cuisineType) {
        return restaurantRepository.findTop3ByCuisineType(cuisineType, PageRequest.of(0, 3));
    }
}