package com.baanBaini.BaanBaini.shared.utility;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperUtility {
    private static ModelMapper mapper;
    {
        mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public <D> D mapModel(Object source, Class<D> destinationType){
        return mapper.map(source,destinationType);
    }
    public <T,D> List<D>  mapList(List<T> list, Class<D> destinationType){
       return list.stream().map(item->mapModel(item,destinationType)).collect(Collectors.toList());
    }
}
