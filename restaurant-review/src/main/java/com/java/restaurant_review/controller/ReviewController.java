package com.java.restaurant_review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.restaurant_review.dto.ReviewDto;
import com.java.restaurant_review.entity.Review;
import com.java.restaurant_review.service.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired private ReviewService reviewService;

    @PostMapping
    public Review submit(@RequestBody @Valid ReviewDto dto) {
        return reviewService.submit(dto);
    }

    @PatchMapping("/{id}/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public Review approve(@PathVariable Long id) {
        return reviewService.approve(id);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Review> getApproved(@PathVariable Long restaurantId) {
        return reviewService.getApproved(restaurantId);
    }
}
