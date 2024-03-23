package com.sb.app.review.ms.service;

import com.sb.app.review.ms.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReview(Long reviewId);

    boolean updateReview(Long reviewId, Review updatedReview);

    boolean deleteReview(Long reviewId);

}
