package com.baanBaini.BaanBaini.kurtis.repository;

import com.baanBaini.BaanBaini.kurtis.models.entity.KurtiEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KurtisRepository extends MongoRepository<KurtiEntity,Long> {

}
