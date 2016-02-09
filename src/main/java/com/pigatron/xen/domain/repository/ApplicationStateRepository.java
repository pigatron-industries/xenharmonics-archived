package com.pigatron.xen.domain.repository;

import com.pigatron.xen.domain.entity.ApplicationState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationStateRepository extends MongoRepository<ApplicationState, String> {
}
