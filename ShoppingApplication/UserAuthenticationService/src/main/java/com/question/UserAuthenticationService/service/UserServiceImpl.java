package com.question.UserAuthenticationService.service;

import com.question.UserAuthenticationService.domain.User;
import com.question.UserAuthenticationService.exception.UserNotFoundException;
import com.question.UserAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }
    @Override
    public User findByEmailAndPassword(String email,String password) throws UserNotFoundException
    {
        User user=userRepository.findByEmailAndPassword(email, password);

        if(user == null)
        {
            throw new UserNotFoundException();
        }
        return user;
    }
    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();

    }


}
