package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.service.dto.CompetenciaColaboradorDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaColaboradorMapper extends EntityMapper<CompetenciaColaboradorDTO, CompetenciaColaborador> {
    @Override
    @Mapping(source = "id.competenciaId", target = "competencia.id")
    @Mapping(source = "competencia.nome", target = "competencia.nome")
    @Mapping(source = "id.colaboradorId", target = "colaborador.id")
    @Mapping(source = "colaborador.nome", target = "colaborador.nome")
    @Mapping(source = "colaborador.sobrenome", target = "colaborador.sobrenome")
    CompetenciaColaboradorDTO toDto(CompetenciaColaborador entity);

    @Override
    @InheritConfiguration
    List<CompetenciaColaboradorDTO> toDto(List<CompetenciaColaborador> entityList);

    @Override
    @InheritInverseConfiguration
    CompetenciaColaborador toEntity(CompetenciaColaboradorDTO dto);

    @Override
    @InheritInverseConfiguration
    List<CompetenciaColaborador> toEntity(List<CompetenciaColaboradorDTO> competenciaColaboradorDTOS);
}
