package com.question.UserProductService.repository;

import com.question.UserProductService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaRepository extends MongoRepository<User,String> {

    User findByEmail(String email);


}