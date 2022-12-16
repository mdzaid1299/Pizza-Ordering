package com.question.UserAuthenticationService.repository;

import com.question.UserAuthenticationService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,String> {
    public User findByEmailAndPassword(String email, String password);

}
