package com.java.restaurant_review.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.restaurant_review.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT r FROM Restaurant r JOIN r.reviews rev WHERE r.cuisineType = :cuisineType AND rev.status = 'APPROVED' GROUP BY r ORDER BY AVG(rev.rating) DESC")
    List<Restaurant> findTop3ByCuisineType(@Param("cuisineType") String cuisineType, PageRequest pageRequest);
}