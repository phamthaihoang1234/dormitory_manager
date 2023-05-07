package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.Repository.UseRepository;
import com.example.dormitory_manager.entities.UserInfo;
import com.example.dormitory_manager.entities.UserPrinciple;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UseRepository userRepository;

    private final MessageSource messageSource;

    private final RoleService roleService;

    public UserServiceImpl(UseRepository userRepository, MessageSource messageSource, RoleService roleService) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
        this.roleService = roleService;
    }

    @Override
    public Iterable<UserInfo> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public UserInfo findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserInfo findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Optional<UserInfo> existsByUsernameAndPassword(String email, String password) throws Exception {
        return userRepository.existsByUsernameAndPassword(email,password);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserInfo save(UserInfo user) throws Exception {

        return userRepository.save(user);
    }

    @Override
    public boolean changePassword(UserInfo user) throws Exception{
        return true;

    }

    @Override
    public UserInfo updateInfor(UserInfo user) throws Exception{
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setGender(user.getGender());

        user.setAddress(user.getAddress());
        return userRepository.save(user);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("vao ham load");
        UserInfo user = userRepository.findByUsername(username);
        System.out.println(user.getPassword());
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.built(user);


    }
}
