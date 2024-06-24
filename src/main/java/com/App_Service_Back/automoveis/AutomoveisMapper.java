package com.App_Service_Back.automoveis;

import com.App_Service_Back.concessionarias.ConcessionariasMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ConcessionariasMapper.class})
public interface AutomoveisMapper {
    AutomoveisMapper INSTANCE = Mappers.getMapper(AutomoveisMapper.class);

    @Mapping(source = "concessionaria", target = "concessionaria")
    AutomoveisDTO toDTO(Automoveis automovel);

    @Mapping(source = "concessionaria", target = "concessionaria")
    Automoveis toEntity(AutomoveisDTO automovelDTO);
}