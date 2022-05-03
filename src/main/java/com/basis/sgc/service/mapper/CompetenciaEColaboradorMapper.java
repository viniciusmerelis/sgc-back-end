package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.TurmaCompetenciaColaborador;
import com.basis.sgc.service.dto.CompetenciaEColaboradorDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaEColaboradorMapper extends EntityMapper<CompetenciaEColaboradorDTO, TurmaCompetenciaColaborador> {

    @Override
    @Mapping(source = "id.competenciaId", target = "competencia.id")
    @Mapping(source = "id.colaboradorId", target = "colaborador.id")
    @Mapping(source = "competencia.nome", target = "competencia.nome")
    @Mapping(source = "colaborador.nome", target = "colaborador.nome")
    @Mapping(source = "colaborador.sobrenome", target = "colaborador.sobrenome")
    CompetenciaEColaboradorDTO toDto(TurmaCompetenciaColaborador entity);

    @Override
    @InheritConfiguration
    List<CompetenciaEColaboradorDTO> toDto(List<TurmaCompetenciaColaborador> entity);

    @Override
    @Mapping(source = "competencia.id", target = "id.competenciaId")
    @Mapping(source = "colaborador.id", target = "id.colaboradorId")
    @Mapping(source = "competencia.nome", target = "competencia.nome")
    @Mapping(source = "colaborador.nome", target = "colaborador.nome")
    @Mapping(source = "colaborador.sobrenome", target = "colaborador.sobrenome")
    TurmaCompetenciaColaborador toEntity(CompetenciaEColaboradorDTO dto);

    @Override
    @InheritConfiguration
    List<TurmaCompetenciaColaborador> toEntity(List<CompetenciaEColaboradorDTO> dto);
}
