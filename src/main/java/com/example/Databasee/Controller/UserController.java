package com.example.Databasee.Controller;

import com.example.Databasee.bo.CreateUserRequest;
import com.example.Databasee.bo.UpdateStatus;
import com.example.Databasee.bo.UserResponse;
import com.example.Databasee.entity.UserEntity;
import com.example.Databasee.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
   private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUser();
    }
   @PostMapping("/create")
   public ResponseEntity<UserResponse> createuser(@RequestBody CreateUserRequest request){
        UserResponse response = userService.createuser(request);
       // Check if the response is not null (indicating a successful creation)
       if (response != null) {
           // Return a 201 Created status code along with the created user data
           return ResponseEntity.status(HttpStatus.CREATED).body(response);
       } else {
           // Handle the case where the creation was not successful (e.g., validation failed)
           // You can return a different status code or error message as needed
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
       }
   }

   @PostMapping("/updateStatus")
public ResponseEntity<String> updateUserStatus(@RequestBody UpdateStatus request) {
        if (!"ACTIVE".equals(request.getStatus())&& !"INACTIVE".equals(request.getStatus())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status must be Active or Inactive");
        }
        boolean isUpdated = userService.updateUserStatus(request.getUserId(),request.getStatus());
        if (isUpdated){return ResponseEntity.ok("Status successfully updated");}
        else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");}
   }
}
// checking for type validation, sanatisation,