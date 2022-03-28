package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.service.dto.CompetenciaColaboradorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetenciaColaboradorMapper extends EntityMapper<CompetenciaColaboradorDTO, CompetenciaColaborador> {

}
