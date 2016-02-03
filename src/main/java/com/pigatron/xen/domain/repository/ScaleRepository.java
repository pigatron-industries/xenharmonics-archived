package com.pigatron.xen.domain.repository;

import com.pigatron.xen.domain.entity.Scale;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScaleRepository extends MongoRepository<Scale, String> {
}
