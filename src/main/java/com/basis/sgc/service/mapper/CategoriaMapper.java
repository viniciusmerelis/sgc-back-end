package com.basis.sgc.service.mapper;

import java.util.List;

import com.basis.sgc.service.dto.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.basis.sgc.domain.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends EntityMapper<CategoriaDTO, Categoria> {

}
