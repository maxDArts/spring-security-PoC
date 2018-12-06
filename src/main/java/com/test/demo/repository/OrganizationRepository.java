package com.ololo.demo.repository;

import com.ololo.demo.entety.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<Organization, String> {
}
