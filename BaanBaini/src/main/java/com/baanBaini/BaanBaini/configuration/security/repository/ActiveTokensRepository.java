package com.baanBaini.BaanBaini.configuration.security.repository;

import com.baanBaini.BaanBaini.configuration.security.model.ActiveTokensEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveTokensRepository extends MongoRepository<ActiveTokensEntity,String> {
    ActiveTokensEntity findByUserId(String userId);
    void deleteByUserId(String userId);
}
