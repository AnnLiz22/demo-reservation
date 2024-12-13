package com.lietz.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.lietz.demo.model.Review;
import com.lietz.demo.repository.ReviewRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ReviewServiceTest {

  @Mock
  ReviewRepository reviewRepository;

  @InjectMocks
  ReviewService reviewService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void findAllReviews() {

    List<Review> reviews = List.of(new Review()
    );

    when(reviewService.findAllReviews()).thenReturn(reviews);
    reviewService.findAllReviews();
    Mockito.verify(reviewRepository, times(1)).findAll();

  }

  @Test
  void findReviewById() {
  }

  @Test
  void createReview() {
  }

  @Test
  void deleteReview() {
  }
}