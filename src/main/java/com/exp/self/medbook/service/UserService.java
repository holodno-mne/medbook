package com.exp.self.medbook.service;

import com.exp.self.medbook.dto.UserDTO;
import com.exp.self.medbook.entity.User;
import com.exp.self.medbook.mapper.UserMapper;
import com.exp.self.medbook.repository.UserReposutory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserReposutory userReposutory;

    public UserService(UserReposutory userReposutory){
        this.userReposutory = userReposutory;
    }

    public UserDTO getUserById(Long id){
        User user = userReposutory.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        return UserMapper.toDTO(user);
    }
}
