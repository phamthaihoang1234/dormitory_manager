package com.example.dormitory_manager.repositories;

import com.example.dormitory_manager.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	UserInfo findByUsername(String username);
}
