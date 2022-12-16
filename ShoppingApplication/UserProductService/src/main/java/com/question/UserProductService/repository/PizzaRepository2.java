package com.question.UserProductService.repository;

import com.question.UserProductService.domain.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaRepository2  extends MongoRepository<Pizza,String> {
}
