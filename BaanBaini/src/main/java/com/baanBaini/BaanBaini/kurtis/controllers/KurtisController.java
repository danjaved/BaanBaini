package com.baanBaini.BaanBaini.kurtis.controllers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.baanBaini.BaanBaini.kurtis.models.dto.KurtisDto;
import com.baanBaini.BaanBaini.kurtis.models.reponseModels.KurtisAdditionResponseModel;
import com.baanBaini.BaanBaini.kurtis.models.requestModels.KurtisAdditionRequestModel;
import com.baanBaini.BaanBaini.kurtis.services.KurtisService;
import com.baanBaini.BaanBaini.shared.urls.ControllerPaths;
import com.baanBaini.BaanBaini.shared.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ControllerPaths.KURTIS_BASE_PATH)
public class KurtisController {
    @Autowired
    KurtisService kurtisService;
    @Autowired
    MapperUtility mapper;

    @PostMapping
    public KurtisAdditionResponseModel addKurti(@ModelAttribute KurtisAdditionRequestModel kurti){
        KurtisDto kurtiDto=mapper.mapModel(kurti,KurtisDto.class);
        kurtiDto = kurtisService.addKurti(kurtiDto);
        return mapper.mapModel(kurtiDto, KurtisAdditionResponseModel.class);
    }
    @GetMapping
    public List<KurtisAdditionResponseModel> getKurtis(){
        List<KurtisDto> kurtiDto=kurtisService.getKurtis();
        return mapper.mapList(kurtiDto, KurtisAdditionResponseModel.class);
    }

    @GetMapping("bucketList")
    public List<String> getBucketList(){
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
        List<Bucket> buckets = s3.listBuckets();
        return buckets.stream().map(bucket -> bucket.getName()).collect(Collectors.toList());
    }
    @GetMapping("testAccess")
    public String testAccess(){
       return "Success";
    }

}
