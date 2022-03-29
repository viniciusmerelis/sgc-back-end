package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.service.dto.CompetenciaNivelDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaNivelMapper extends EntityMapper<CompetenciaNivelDTO, CompetenciaColaborador> {
    @Override
    @Mapping(source = "id.competenciaId", target = "id")
    @Mapping(source = "competencia.nome", target = "nome")
    @Mapping(source = "competencia.descricao", target = "descricao")
    @Mapping(source = "competencia.categoria.id", target = "categoria.id")
    @Mapping(source = "competencia.categoria.nome", target = "categoria.nome")
    @Mapping(source = "nivel", target = "nivel")
    CompetenciaNivelDTO toDto(CompetenciaColaborador entity);

    @Override
    @InheritConfiguration
    List<CompetenciaNivelDTO> toDto(List<CompetenciaColaborador> entityList);

    @Override
    @InheritInverseConfiguration
    CompetenciaColaborador toEntity(CompetenciaNivelDTO dto);
}
