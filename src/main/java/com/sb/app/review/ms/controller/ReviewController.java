package com.sb.app.review.ms.controller;

import com.sb.app.review.ms.entity.Review;
import com.sb.app.review.ms.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {

        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if (isReviewSaved)
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {
        Review review = reviewService.getReview(reviewId);
        if (Objects.nonNull(review))
            return ResponseEntity.ok(review);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                                               @RequestBody Review review) {
        if (reviewService.updateReview(reviewId, review))
            return new ResponseEntity<>("Review updated successfully",
                    HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated",
                    HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        if (reviewService.deleteReview(reviewId))
            return new ResponseEntity<>("Review deleted successfully",
                    HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not deleted",
                    HttpStatus.OK);
    }

}


