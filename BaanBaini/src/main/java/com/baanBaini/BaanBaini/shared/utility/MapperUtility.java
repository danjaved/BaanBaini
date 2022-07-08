package com.baanBaini.BaanBaini.shared.utility;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class MapperUtility {
    public <D> D mapModel(Object source, Class<D> destinationType){
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(source,destinationType);
    }
}
