package com.example.Databasee.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
//@Table(name = "Bank_user")
//camel case wont work in SQL
public class UserEntity {
   @Id
           @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String name;
   private Status status;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
