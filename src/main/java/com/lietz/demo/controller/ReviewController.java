package com.lietz.demo.controller;

import com.lietz.demo.model.Review;
import com.lietz.demo.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
  private final ReviewService reviewService;

  @GetMapping
  public ResponseEntity<List<Review>> getAllReviews() {
    List<Review> reviews = reviewService.findAllReviews();
    return ResponseEntity.ok(reviews);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
    try {

      Review review = reviewService.findReviewById(id);
      return ResponseEntity.ok(review);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Review> createReview(@RequestBody Review review) {
    Review newReview = reviewService.createReview(review);
    return ResponseEntity.status(HttpStatus.CREATED).body(newReview);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReview(@PathVariable Long id){
    try {
      reviewService.deleteReview(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e){
      return ResponseEntity.notFound().build();
    }
  }
}
