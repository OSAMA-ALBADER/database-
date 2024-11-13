package com.example.Databasee.service;

import com.example.Databasee.bo.CreateUserRequest;
import com.example.Databasee.bo.UserResponse;
import com.example.Databasee.entity.Status;
import com.example.Databasee.entity.UserEntity;
import com.example.Databasee.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }



    public UserResponse createuser(CreateUserRequest request){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        //Controller Layer Updates
    userEntity.setStatus(Status.valueOf(request.getStatus()));
       userRepository.save(userEntity);
       userEntity = userRepository.save(userEntity);
       //Service Layer Enhancement:
        UserResponse response = new UserResponse(userEntity.getId(), userEntity.getName(),userEntity.getStatus().toString());
        return response;
    }

    @Override
    public boolean updateUserStatus(Long userId, String status) {
        Status newStatus = Status.valueOf(status);
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            UserEntity user = optionalUser.get();
            user.setStatus(newStatus);
            userRepository.save(user);
            return true;
        }else {
        return false;
    }
    }
}
