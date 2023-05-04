package com.example.dormitory_manager.Services;




import com.example.dormitory_manager.entities.Review;
import com.example.dormitory_manager.entities.UserInfo;

import java.util.Optional;

public interface ReviewService {
    Iterable<Review> findAll();

    Review save(Review review1);



    void delete(Long id);

    Optional<Review> findById(Long id);
}
