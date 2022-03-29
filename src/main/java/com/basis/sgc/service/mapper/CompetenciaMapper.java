package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia> {

}
