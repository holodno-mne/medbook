package com.exp.self.medbook.Service;

import com.exp.self.medbook.DTO.UserDTO;
import com.exp.self.medbook.Entity.User;
import com.exp.self.medbook.Mapper.UserMapper;
import com.exp.self.medbook.Repository.UserReposutory;
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
