package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.CompetenciaDTO;
import com.basis.sgc.service.dto.input.CompetenciaDtoInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia> {

}
