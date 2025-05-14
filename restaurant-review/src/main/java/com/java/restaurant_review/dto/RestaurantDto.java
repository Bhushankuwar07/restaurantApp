package com.java.restaurant_review.dto;

import com.java.restaurant_review.entity.PriceRange;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestaurantDto {

    @NotBlank
    private String name;

    @NotBlank
    private String cuisineType;

    @NotBlank
    private String address;

    @NotNull
    private PriceRange priceRange;

    // Constructors
    public RestaurantDto() {}

    public RestaurantDto(String name, String cuisineType, String address, PriceRange priceRange) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.address = address;
        this.priceRange = priceRange;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }
}