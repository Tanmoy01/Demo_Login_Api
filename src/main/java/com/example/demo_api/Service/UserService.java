package com.example.demo_api.Service;

import com.example.demo_api.Model.User;
import com.example.demo_api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String registerUser(User newUser){
        List<User> users = userRepository.findAll();
        //System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            //System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                return "Already exists";
            }
        }
        userRepository.save(newUser);
        return "User added successful";
    }

    public String loginUser(String username, String password){
        List<User> users = userRepository.findAll();
        //System.out.println(users);
        for (User other : users) {
            if(other.getUsername().equals(username) && other.getPassword().equals(password)){
                return "Logged in successful";
            }
        }
        return "try again";
    }

    public String deleteUser(String username, String password){
        List<User> users = userRepository.findAll();
        //System.out.println(users.toString());
        for (User other : users) {
            if(other.getUsername().equals(username) && other.getPassword().equals(password)){
                userRepository.delete(other);
                return "Deleted";
            }
        }
        return "Invalid";
    }

}
