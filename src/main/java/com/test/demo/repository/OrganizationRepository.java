package com.test.demo.repository;

import com.test.demo.entety.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<Organization, String> {
}
