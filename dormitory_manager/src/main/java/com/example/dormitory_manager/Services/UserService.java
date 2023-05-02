package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.entities.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> getAllUsers();

    UserInfo getUserById(Long id);

    UserInfo createUser(UserInfo user);

    UserInfo updateUser(Long id, UserInfo user);

    boolean deleteUser(Long id);

}
