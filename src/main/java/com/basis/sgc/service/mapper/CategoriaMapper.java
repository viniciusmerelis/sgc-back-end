package com.basis.sgc.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.service.dto.CategoriaDto;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	CategoriaDto toDto(Categoria categoria);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	List<CategoriaDto> toDto(List<Categoria> categorias);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	Categoria toEntity(CategoriaDto categoriaDto);
}
