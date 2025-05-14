package com.java.restaurant_review.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.restaurant_review.entity.Review;
import com.java.restaurant_review.entity.ReviewStatus;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.restaurant.id = :restaurantId AND r.status = 'APPROVED'")
    Double findAverageRating(@Param("restaurantId") Long restaurantId);

    List<Review> findByRestaurantIdAndStatus(Long restaurantId, ReviewStatus status);
}

