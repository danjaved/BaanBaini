package com.baanBaini.BaanBaini.kurtis.services;

import com.baanBaini.BaanBaini.kurtis.models.dto.KurtisDto;

import java.util.List;

public interface KurtisService {
    KurtisDto addKurti(KurtisDto kurti);
    List<KurtisDto> getKurtis();
}
