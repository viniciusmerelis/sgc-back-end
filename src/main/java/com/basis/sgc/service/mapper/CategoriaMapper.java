package com.basis.sgc.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.service.dto.CategoriaDto;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

	CategoriaDto toDto(Categoria categoria);
	
	List<CategoriaDto> toDto(List<Categoria> categorias);
	
	Categoria toEntity(CategoriaDto categoriaDto);
}
