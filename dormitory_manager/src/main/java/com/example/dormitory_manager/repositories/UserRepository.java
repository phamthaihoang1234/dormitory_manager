package com.example.dormitory_manager.repositories;

import com.example.dormitory_manager.entities.UserInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfor, Long> {
	UserInfor findByUsername(String username);
}
