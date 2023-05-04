package com.example.dormitory_manager.services;

import com.example.dormitory_manager.entities.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> getAllUsers();

    UserInfo getUserById(Long id);

    UserInfo createUser(UserInfo user);

    UserInfo updateUser(Long id, UserInfo user);
    
    UserInfo findByUserName(String username);


    boolean deleteUser(Long id);

}
