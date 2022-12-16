package com.question.UserProductService.service;

import com.question.UserProductService.domain.Pizza;
import com.question.UserProductService.domain.User;
import com.question.UserProductService.exception.UserAlreadyExistsException;
import com.question.UserProductService.exception.UserNotFoundException;

import java.util.List;

public interface PizzaService {
    User registerUser(User user) throws UserAlreadyExistsException;

    User saveUserPizzaToList(Pizza pizza, String email) throws UserNotFoundException;


    List<Pizza> getOrderDetails(String email) throws UserNotFoundException;



    User deleteFromPizzaList(String email, String pizzaName);
}
