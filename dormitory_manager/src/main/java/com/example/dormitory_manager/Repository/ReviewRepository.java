package com.example.dormitory_manager.Repository;

import com.example.dormitory_manager.entities.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Query(value = "select * from reviews left join bookings on reviews.booking_id = bookings.id left join rooms on bookings.room_id = rooms.id left join users on bookings.user_id = users.id where bookings.room_id = ?1 order by reviews.id desc", nativeQuery = true)
    Iterable<Review> findByRoomIdQuery(Long id);

    @Query(value = "select avg(rating) from reviews left join bookings on reviews.booking_id = bookings.id left join rooms on bookings.room_id = rooms.id where room_id = ?1", nativeQuery = true)
    Object findAvgRattingByRoomIdQuery(Long id);

    @Query(value = "select * from review where status = 1", nativeQuery = true)
    Iterable<Review> findAllReviewAvailable();
}
