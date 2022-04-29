package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.service.dto.CompetenciaEColaboradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaEColaboradorMapper extends EntityMapper<CompetenciaEColaboradorDTO, CompetenciaColaborador> {

    @Override
    @Mapping(source = "competencia.id", target = "id.competenciaId")
    @Mapping(source = "colaborador.id", target = "id.colaboradorId")
    List<CompetenciaColaborador> toEntity(List<CompetenciaEColaboradorDTO> dto);

    @Override
    @Mapping(source = "id.competenciaId" ,target = "competencia.id")
    @Mapping(source = "id.colaboradorId", target = "")
    List<CompetenciaEColaboradorDTO> toDto(List<CompetenciaColaborador> entity);
}
