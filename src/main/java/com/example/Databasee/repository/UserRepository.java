package com.example.Databasee.repository;

import com.example.Databasee.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<UserEntity, Long> {
}

//only can add methode , it is going to be generated, because we are inheriting from jpaRepository
// responsible for the data, accessing data
//controller for the client
// service for in between, doing the bussnius logic
// he is like a middelman
