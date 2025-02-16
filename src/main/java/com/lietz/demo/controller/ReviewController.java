package com.lietz.demo.controller;

import com.lietz.demo.model.Review;
import com.lietz.demo.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
  private final ReviewService reviewService;

  @GetMapping
  public String getAllReviews(Model model) {
    List<Review> reviews = reviewService.findAllReviews();
    model.addAttribute("reviews", reviews);
    return "reviews/list";
  }

  @GetMapping("/{id}")
  public String getReviewById(@PathVariable Long id, Model model) {
    try {

      Review review = reviewService.findReviewById(id);
      model.addAttribute("review", review);
      return "reviews/details";
    } catch (RuntimeException e) {
      return "error/404";
    }
  }

  @PostMapping
  public String createReview(@ModelAttribute Review review, Model model) {
    Review newReview = reviewService.createReview(review);
    model.addAttribute("review", newReview);
    return "reviews/list";
  }

  @DeleteMapping("/{id}")
  public String deleteReview(@PathVariable Long id){
    try {
      reviewService.deleteReview(id);
      return "reviews/list";
    } catch (RuntimeException e){
      return "error/404";
    }
  }
}
