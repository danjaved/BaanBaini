package com.baanBaini.BaanBaini.admin.repository;

import com.baanBaini.BaanBaini.admin.model.entity.AdminEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<AdminEntity,Long> {
    AdminEntity findByEmail(String email);
    AdminEntity findByPublicAdminId(String publicAdminId);
}
