package com.question.UserAuthenticationService.service;

import com.question.UserAuthenticationService.domain.User;
import com.question.UserAuthenticationService.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public User findByEmailAndPassword(String email,String password) throws UserNotFoundException;

    List<User> getAllUsers();
}
