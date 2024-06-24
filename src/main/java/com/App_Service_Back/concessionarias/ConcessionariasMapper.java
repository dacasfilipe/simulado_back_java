package com.App_Service_Back.concessionarias;

import com.App_Service_Back.concessionarias.Concessionarias;
import com.App_Service_Back.concessionarias.ConcessionariasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConcessionariasMapper {
    ConcessionariasMapper INSTANCE = Mappers.getMapper(ConcessionariasMapper.class);

    ConcessionariasDTO toDTO(Concessionarias concessionaria);
    Concessionarias toEntity(ConcessionariasDTO concessionariaDTO);
}