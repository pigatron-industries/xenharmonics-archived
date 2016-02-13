package com.pigatron.xen.domain.repository;


import com.pigatron.xen.domain.entity.DissonanceCurve;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DissonanceCurveRepository extends MongoRepository<DissonanceCurve, String> {
}
