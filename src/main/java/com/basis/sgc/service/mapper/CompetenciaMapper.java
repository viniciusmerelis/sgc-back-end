package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.CompetenciaDto;
import com.basis.sgc.service.dto.input.CompetenciaDtoInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper {

    @Mapping(source = "categoria.id", target = "categoria.id")
    @Mapping(source = "categoria.nome", target = "categoria.nome")
    CompetenciaDto toDto(Competencia competencia);

    @Mapping(source = "categoria.id", target = "categoria.id")
    @Mapping(source = "categoria.nome", target = "categoria.nome")
    List<CompetenciaDto> toDto(List<Competencia> competencias);

    @Mapping(source = "categoriaId", target = "categoria.id")
    @Mapping(target = "id", ignore = true)
    Competencia toEntity(CompetenciaDtoInput competenciaDtoInput);
}
