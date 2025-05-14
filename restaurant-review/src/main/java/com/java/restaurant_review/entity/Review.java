package com.java.restaurant_review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;



@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Restaurant restaurant;

    @Min(1) @Max(5)
    private int rating;

    private String comment;

    private LocalDate visitDate;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    public Review() { }
    
    
	public Review(Long id, Restaurant restaurant, @Min(1) @Max(5) int rating, String comment, LocalDate visitDate,
			ReviewStatus status) {
		super();
		this.id = id;
		this.restaurant = restaurant;
		this.rating = rating;
		this.comment = comment;
		this.visitDate = visitDate;
		this.status = status;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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

	public ReviewStatus getStatus() {
		return status;
	}

	public void setStatus(ReviewStatus status) {
		this.status = status;
	}
    

}