package com.baanBaini.BaanBaini.kurtis.serivceImplementation;

import com.baanBaini.BaanBaini.kurtis.models.dto.KurtisDto;
import com.baanBaini.BaanBaini.kurtis.models.entity.KurtiEntity;
import com.baanBaini.BaanBaini.kurtis.repository.KurtisRepository;
import com.baanBaini.BaanBaini.kurtis.services.KurtisService;
import com.baanBaini.BaanBaini.shared.utility.MapperUtility;
import com.baanBaini.BaanBaini.shared.utility.S3Helper;
import com.baanBaini.BaanBaini.shared.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KurtisServiceImplementation implements KurtisService {

    @Autowired
    KurtisRepository kurtisRepository;

    @Autowired
    MapperUtility mapper;

    @Autowired
    Utility utility;

    @Override
    public KurtisDto addKurti(KurtisDto kurti) {
        kurti.setPublicId(utility.getRandomString("KUR",9));
        S3Helper.saveImages(kurti.getPublicId(),kurti.getMultipartImages());
        KurtiEntity kurtiEntity = mapper.mapModel(kurti, KurtiEntity.class);
        kurtiEntity = kurtisRepository.save(kurtiEntity);
        return mapper.mapModel(kurtiEntity, KurtisDto.class);
    }

    @Override
    public List<KurtisDto> getKurtis() {
        List<KurtiEntity> kurtiEntities = kurtisRepository.findAll();
        List<KurtisDto> kurtisDtos =mapper.mapList(kurtiEntities, KurtisDto.class);
        for (KurtisDto kurti:kurtisDtos) {
            kurti.setImages(S3Helper.getKurtiImages(kurti.getPublicId()));
        }
        return kurtisDtos;
    }
}
