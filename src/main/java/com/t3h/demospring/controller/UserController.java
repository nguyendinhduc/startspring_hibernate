package com.t3h.demospring.controller;

import com.t3h.demospring.UserProfile;
import com.t3h.demospring.model.User;
import com.t3h.demospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lap trinh on 5/18/2018.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private List<UserProfile> userProfiles = new ArrayList<UserProfile>();
    @GetMapping("/api/register")
    public Object register(
            @RequestParam("username") String username,
            @RequestParam("passsword") String password
    ){
        for (UserProfile userProfile : userProfiles) {
            if ( userProfile.getUsername().equals(username)) {
                return "Register not success";
            }
        }
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(username);
        userProfile.setPassword(password);
        userProfiles.add(userProfile);
        return userProfile;
    }


    @GetMapping("/getAll")
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
