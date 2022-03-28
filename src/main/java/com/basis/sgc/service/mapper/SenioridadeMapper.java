package com.basis.sgc.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.service.dto.SenioridadeDto;

@Mapper(componentModel = "spring")
public interface SenioridadeMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	SenioridadeDto toDto(Senioridade senioridade);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	List<SenioridadeDto> toDto(List<Senioridade> senioridade);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	Senioridade toEntity(SenioridadeDto senioridadeDto);
}
