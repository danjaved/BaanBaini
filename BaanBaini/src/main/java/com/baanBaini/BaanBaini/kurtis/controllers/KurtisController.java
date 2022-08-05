package com.baanBaini.BaanBaini.kurtis.controllers;

import com.baanBaini.BaanBaini.kurtis.models.dto.KurtisDto;
import com.baanBaini.BaanBaini.kurtis.models.reponseModels.KurtisAdditionResponseModel;
import com.baanBaini.BaanBaini.kurtis.models.requestModels.KurtisAdditionRequestModel;
import com.baanBaini.BaanBaini.kurtis.services.KurtisService;
import com.baanBaini.BaanBaini.shared.urls.ControllerPaths;
import com.baanBaini.BaanBaini.shared.utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ControllerPaths.KURTIS_BASE_PATH)
public class KurtisController {
    @Autowired
    KurtisService kurtisService;
    @Autowired
    MapperUtility mapper;

    @PostMapping
    public KurtisAdditionResponseModel addKurti(@ModelAttribute KurtisAdditionRequestModel kurti){
        return null;
//        KurtisDto kurtiDto=mapper.mapModel(kurti,KurtisDto.class);
//        kurtiDto = kurtisService.addKurti(kurtiDto);
//        return mapper.mapModel(kurtiDto, KurtisAdditionResponseModel.class);
    }
    @GetMapping
    public List<KurtisAdditionResponseModel> getKurtis(){
        List<KurtisDto> kurtiDto=kurtisService.getKurtis();
        return mapper.mapList(kurtiDto, KurtisAdditionResponseModel.class);
    }
}
