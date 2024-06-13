package com.builder.deckbuilder.controller;

import com.builder.deckbuilder.dao.UserDao;
import com.builder.deckbuilder.model.User;
import com.builder.deckbuilder.model.UserDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private UserDao userDao;
    @PutMapping(path="/update")
    public User updateUserProfile(int userId, UserDTO updatedUser){
        return userDao.updateUserProfile(userId, updatedUser);
    }
}
