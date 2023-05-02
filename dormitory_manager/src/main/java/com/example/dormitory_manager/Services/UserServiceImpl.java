package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.entities.UserInfo;
import com.example.dormitory_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo getUserById(Long id) {
        Optional<UserInfo> user = userRepository.findById(id);
        return user.orElse(null);
    }
    
        
    @Override
    public UserInfo createUser(UserInfo user) {
        UserInfo newUser = new UserInfo();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(user.getRoles());
        return userRepository.save(newUser);
    }

    @Override
    public UserInfo updateUser(Long id, UserInfo user) {
        Optional<UserInfo> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserInfo existingUser = optionalUser.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setRoles(user.getRoles());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<UserInfo> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
