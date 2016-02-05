package com.pigatron.xen.domain.repository;

import com.pigatron.xen.domain.entity.Scale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScaleRepository extends MongoRepository<Scale, String> {
}
