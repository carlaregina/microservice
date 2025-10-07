package com.ms.user.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ms.user.dtos.UserDTO;
import com.ms.user.models.User;
import com.ms.user.repositories.UserRepository;

import com.ms.user.models.EmailStatusResponse;
import com.ms.user.producers.UserProducer;  

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    public User create(UserDTO userDto){
        var user =  new User();
        BeanUtils.copyProperties(userDto, user);
        user =  userRepository.save(user);
        userProducer.publishMessageEmail(user);
        return user;
    }

    public User updateStatus(EmailStatusResponse emailStatusResponse){
        Optional<User> user = userRepository.findById(emailStatusResponse.getUserId());
        if(user.isEmpty()) return null;
        user.get().setStatus(emailStatusResponse.getStatus());
        return userRepository.save(user.get());
    }
}
