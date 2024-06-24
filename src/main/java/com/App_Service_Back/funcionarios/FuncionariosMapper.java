package com.App_Service_Back.funcionarios;

import com.App_Service_Back.concessionarias.ConcessionariasMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ConcessionariasMapper.class})
public interface FuncionariosMapper {
    FuncionariosMapper INSTANCE = Mappers.getMapper(FuncionariosMapper.class);

    @Mapping(source = "concessionarias", target = "concessionarias")
    FuncionariosDTO toDTO(Funcionarios funcionario);

    @Mapping(source = "concessionarias", target = "concessionarias")
    Funcionarios toEntity(FuncionariosDTO funcionarioDTO);
}