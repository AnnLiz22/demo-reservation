package com.lietz.demo.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.lietz.demo.model.Review;
import com.lietz.demo.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
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

  List<Review> reviews = List.of(new Review(1L, 1L, 1L, 1L, 4.5, "Very nice!"),
      new Review(2L, 1L, 1L, 1L, 4.9, "I really enjoyed!"),
      new Review(3L, 2L, 1L, 3L, 4.1, "ok"),
      new Review(4L, 1L, 5L, 1L, 4.4, "Great fun and great accommodation!"));


  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void shouldFindAllReviews() {

    List<Review> reviews = List.of(new Review()
    );

    when(reviewRepository.findAll()).thenReturn(reviews);
    reviewService.findAllReviews();
    Mockito.verify(reviewRepository, times(1)).findAll();

  }

  @Test
  void shouldFindReviewByIdAndReturnComment() {
    Review review1 = reviews.get(0);

    when(reviewRepository.findById(1L)).thenReturn(Optional.ofNullable(review1));
    reviewService.findReviewById(1L);
    Mockito.verify(reviewRepository, times(1)).findById(1L);
    Assertions.assertEquals("Very nice!", review1.getComment());
    Assertions.assertEquals(4.5, review1.getRating());
  }


  @Test
  void shouldCreateReview() {

    Review review = new Review(11L, 1L, 13L, 4L, 4.5, "satisfied");
    when(reviewRepository.save(review)).thenReturn(review);
    reviewService.createReview(review);
    Mockito.verify(reviewRepository, times(1)).save(review);
    Assertions.assertEquals("satisfied", review.getComment());
  }

  @Test
  void shouldInvokeDeleteReviewByIdFromRepository() {

    reviewService.deleteReview(1L);
    Mockito.verify(reviewRepository, times(1)).deleteById(1L);
  }
}