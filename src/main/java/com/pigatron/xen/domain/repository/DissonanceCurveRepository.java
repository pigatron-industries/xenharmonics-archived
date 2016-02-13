package com.pigatron.xen.domain.repository;


import com.pigatron.xen.domain.entity.DissonanceCurve;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DissonanceCurveRepository extends MongoRepository<DissonanceCurve, String> {
}
