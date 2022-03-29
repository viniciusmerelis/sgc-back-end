package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.service.dto.ColaboradorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CompetenciaNivelMapper.class)
public interface ColaboradorMapper extends EntityMapper<ColaboradorDTO, Colaborador> {

}
