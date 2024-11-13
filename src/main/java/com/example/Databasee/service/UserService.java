package com.example.Databasee.service;

import com.example.Databasee.bo.CreateUserRequest;
import com.example.Databasee.bo.UserResponse;
import com.example.Databasee.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUser();

    UserResponse createuser(CreateUserRequest request);

    boolean updateUserStatus(Long userId, String status);
}
