package com.example.Databasee.bo;

import com.example.Databasee.entity.Status;

public class UserResponse {
    private Long id;
    private String name;
    private String status;

    public UserResponse(Long id, String name, String status) {
        this.id = id;
        this.name = name;
       this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNam() {
        return name;
    }

    public void setNam(String nam) {
        this.name = nam;
    }


}
