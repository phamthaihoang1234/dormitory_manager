package com.example.dormitory_manager.Repository;

import com.example.dormitory_manager.entities.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UseRepository extends CrudRepository<UserInfo, Long> {

    Optional<UserInfo> findByNameAndPassword(String name, String password);

    UserInfo findByEmail(String email);

    UserInfo findByUsername(String username);

    boolean existsByUsername(String username);

    @Query(value = "SELECT * FROM booking_hotelver10.users where username=?1", nativeQuery = true)// and password=?2;
    Optional<UserInfo> existsByUsernameAndPassword(String email,String password);
}
