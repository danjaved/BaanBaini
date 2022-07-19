package com.baanBaini.BaanBaini.user.repository;

import com.baanBaini.BaanBaini.user.model.entity.UserEntity;
import com.baanBaini.BaanBaini.user.model.entity.UserEntity2;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity2,Long> {
    UserEntity2 findByEmail(String email);
    UserEntity2 findByPublicUserId(String publicUserId);
}
