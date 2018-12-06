package com.test.demo.repository;

import com.test.demo.entety.Permission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PermissionRepository extends MongoRepository<Permission, String> {
    List<Permission> findAllByUserId(String userId);
}
