package com.java.restaurant_review.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;



public class ReviewDto {
    @NotNull
    private Long restaurantId;

    @Min(1)
    @Max(5)
    private int rating;

    private String comment;

    @NotNull
    private LocalDate visitDate;

    // Constructors
    public ReviewDto() {}

    public ReviewDto(Long restaurantId, int rating, String comment, LocalDate visitDate) {
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.comment = comment;
        this.visitDate = visitDate;
    }

    // Getters and Setters
    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }
}