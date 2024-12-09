package com.lietz.demo.service;

import com.lietz.demo.model.Review;
import com.lietz.demo.repository.ReviewRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
  private final ReviewRepository reviewRepository;

  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  public List<Review> findAllReviews(){
    return reviewRepository.findAll();
  }

  public Review findReviewById(Long id){
    return reviewRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Review not found"));
  }

  public Review createReview(Review review){
    return reviewRepository.save(review);
  }

  public void deleteReview(Long id){
    reviewRepository.deleteById(id);
  }
}
