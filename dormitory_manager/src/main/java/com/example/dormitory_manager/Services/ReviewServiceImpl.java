package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.Repository.ReviewRepository;
import com.example.dormitory_manager.entities.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Iterable<Review> findAll() {
        return reviewRepository.findAllReviewAvailable();
    }

    @Override
    public Review save(Review review1) {
        return reviewRepository.save(review1);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }
}
