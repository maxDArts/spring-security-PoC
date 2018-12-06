package com.ololo.demo.repository;

import com.ololo.demo.entety.Permission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PermissionRepository extends MongoRepository<Permission, String> {
    List<Permission> findAllByUserId(String userId);
}
