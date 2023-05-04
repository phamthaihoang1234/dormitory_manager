package com.example.dormitory_manager.Controller;

import com.example.dormitory_manager.Repository.ReviewRepository;
import com.example.dormitory_manager.Services.ReviewService;
import com.example.dormitory_manager.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ReviewService reviewService;
	

	@GetMapping("/addReview")
	public Review addReview(long id, Review review) {
		if(review!= null) {
			return reviewRepository.save(review);

		}
		return null;
	}

	@Override
	public Review updateReview(long id, Review review) {
		if(review!= null) {
			Review review1 = reviewRepository.getById(id);
			if(review1!=null) {
				review1.setReviewBody(review.getReviewBody());
				review1.setRating(review.getRating());
				review1.setActive(review.getActive());
				
				return reviewRepository.save(review1);
			}
		}
		return null;
	}

	@Override
	public boolean deleteReview(long id) {
		if(id>=1) {
			Review review = reviewRepository.getById(id);
			if(review!=null){
				reviewRepository.delete(review);
				return true;
			}
		}
		return false;
	}
}



