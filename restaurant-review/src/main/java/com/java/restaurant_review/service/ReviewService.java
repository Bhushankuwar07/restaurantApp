package com.java.restaurant_review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.restaurant_review.dto.ReviewDto;
import com.java.restaurant_review.entity.Restaurant;
import com.java.restaurant_review.entity.Review;
import com.java.restaurant_review.entity.ReviewStatus;
import com.java.restaurant_review.repository.RestaurantRepository;
import com.java.restaurant_review.repository.ReviewRepository;

@Service
public class ReviewService {
	 @Autowired 
	 private ReviewRepository reviewRepository;
	    @Autowired 
	    private RestaurantRepository restaurantRepository;

	    public Review submit(ReviewDto dto) {
	        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).orElseThrow();
	        Review review = new Review();
	        review.setRestaurant(restaurant);
	        review.setRating(dto.getRating());
	        review.setComment(dto.getComment());
	        review.setVisitDate(dto.getVisitDate());
	        review.setStatus(ReviewStatus.PENDING);
	        return reviewRepository.save(review);
	    }

	    public List<Review> getApproved(Long restaurantId) {
	        return reviewRepository.findByRestaurantIdAndStatus(restaurantId, ReviewStatus.APPROVED);
	    }

	    public Review approve(Long reviewId) {
	        Review review = reviewRepository.findById(reviewId).orElseThrow();
	        review.setStatus(ReviewStatus.APPROVED);
	        return reviewRepository.save(review);
	    }
	}



