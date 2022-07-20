package com.baanBaini.BaanBaini.user.repository;

import com.baanBaini.BaanBaini.user.model.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity findByPublicUserId(String publicUserId);
}
