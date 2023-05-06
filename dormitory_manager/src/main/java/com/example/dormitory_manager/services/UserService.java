package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.entities.UserInfor;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


public interface UserService extends UserDetailsService {
    Iterable<UserInfor> findAll();

    Optional<UserInfor> findById(Long id);

    UserInfor findByEmail(String email);

    UserInfor save(UserInfor user) throws Exception;

    UserInfor findByUserName(String username);

    boolean existsByUsername(String username);

    public UserInfor updateInfor(UserInfor user) throws Exception;

    public boolean changePassword(UserInfor user) throws Exception;

    Optional<UserInfor> existsByUsernameAndPassword(String email, String password) throws Exception;

    void delete(Long id);
}
