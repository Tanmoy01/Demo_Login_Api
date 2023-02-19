package com.example.demo_api.Controller;
import java.util.*;

import com.example.demo_api.Model.User;
import com.example.demo_api.Repository.UserRepository;
import com.example.demo_api.Service.UserService;
import jakarta.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/sign_up")
    public ResponseEntity registerUser(@RequestBody User newUser) {

        String response= userService.registerUser(newUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users/login")
    public ResponseEntity loginUser(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        String response = userService.loginUser(username, password);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestParam("username") String username,
                                     @RequestParam("password") String password){
        String response = userService.deleteUser(username, password);
        if (response.equals("Deleted")){
            return new ResponseEntity<>(response,HttpStatus.FOUND);
        }
        if(response.equals("try again"))
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
