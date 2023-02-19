package com.example.demo_api.Controller;

import com.example.demo_api.Model.User;
import com.example.demo_api.Model.UserDetails;
import com.example.demo_api.Model.UserLogin;
import com.example.demo_api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/sign_up")
    public ResponseEntity registerUser(@RequestBody UserDetails newUser) {

        try {
            String response = userService.registerUser(newUser);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserLogin user) {
        try {
            String response = userService.loginUser(user);
            if ("successful".equals(response))
                return new ResponseEntity<>(response, HttpStatus.OK);
            else
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody UserLogin user) {
        try {
            String response = userService.deleteUser(user);
            if ("successful".equals(response))
                return new ResponseEntity<>(response, HttpStatus.OK);
            else
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestParam String userName, @RequestBody UserDetails user) {
        try {
            String response = userService.updateUser(userName, user);
            if ("successful".equals(response))
                return new ResponseEntity<>(response, HttpStatus.OK);
            else
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
