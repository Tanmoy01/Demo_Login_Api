package com.example.demo_api.Service;

import com.example.demo_api.Model.User;
import com.example.demo_api.Model.UserDetails;
import com.example.demo_api.Model.UserLogin;
import com.example.demo_api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String registerUser(UserDetails newUser) {
        User user = userRepository.findByUsername(newUser.getUsername());
        if (user != null)
            return "User already exists";

        user = new User();
        user.setName(newUser.getName());
        user.setSurname(newUser.getSurname());
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
        return "User added successful";
    }

    public String loginUser(UserLogin userLogin) {
        User user = userRepository.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());
        if (user != null)
            return "successful";
        return "User does not exist";
    }

    public String deleteUser(UserLogin userLogin) {
        User user = userRepository.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());
        if (user != null) {
            userRepository.delete(user);
            return "successful";
        }
        return "User does not exist";

    }

    public String updateUser(String userName, UserDetails userDetails){
        User user = userRepository.findByUsername(userName);
        if (user == null)
            return "User does not exist";

        user.setName(userDetails.getName());
        user.setSurname(userDetails.getSurname());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        userRepository.save(user);
        return "successful";
    }
}
