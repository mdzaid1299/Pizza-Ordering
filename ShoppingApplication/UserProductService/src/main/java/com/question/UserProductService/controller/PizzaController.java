package com.question.UserProductService.controller;

import com.question.UserProductService.domain.Pizza;
import com.question.UserProductService.domain.User;
import com.question.UserProductService.exception.UserAlreadyExistsException;
import com.question.UserProductService.exception.UserNotFoundException;
import com.question.UserProductService.repository.PizzaRepository2;
import com.question.UserProductService.service.PizzaService;
import com.question.UserProductService.service.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class PizzaController {

    private PizzaService pizzaService;
    private ResponseEntity responseEntity;
    private PizzaServiceImpl pizzaServiceImpl;
    private PizzaRepository2 pizzaRepository2;

    @Autowired
    public PizzaController(PizzaService pizzaService, PizzaServiceImpl pizzaServiceImpl, PizzaRepository2 pizzaRepository2) {
        this.pizzaService = pizzaService;
        this.pizzaServiceImpl = pizzaServiceImpl;
        this.pizzaRepository2 = pizzaRepository2;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        try {
            System.out.println("register working");

            responseEntity = new ResponseEntity<>(pizzaService.registerUser(user), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }

    @PostMapping("/user/{email}/pizzaList")
    public ResponseEntity<?> saveUserPizzaToList(@RequestBody Pizza pizza, @PathVariable String email) throws UserNotFoundException {
        System.out.printf("post running");
        try {
            responseEntity = new ResponseEntity<>(pizzaService.saveUserPizzaToList(pizza, email), HttpStatus.CREATED);
        } catch (UserNotFoundException userNotFoundException) {
            throw new UserNotFoundException();
        }
        System.out.println();
        return responseEntity;
    }

    @GetMapping("/order/{email}")
    public ResponseEntity<?> getAllPizzaOrdered(@PathVariable String email) throws UserNotFoundException {
        try {
            System.out.println("get pizza running");
            responseEntity = new ResponseEntity<>(pizzaService.getOrderDetails(email), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }


    @DeleteMapping("/delete/{email}/{pizzaName}")
    public ResponseEntity<?> deleteFromPizzaList(@PathVariable String email, @PathVariable String pizzaName) {
        return new ResponseEntity<>(pizzaService.deleteFromPizzaList(email, pizzaName), HttpStatus.OK);
    }

}




