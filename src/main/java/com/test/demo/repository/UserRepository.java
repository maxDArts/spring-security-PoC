package com.test.demo.repository;

import com.test.demo.entety.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByLogin(String login);
}
