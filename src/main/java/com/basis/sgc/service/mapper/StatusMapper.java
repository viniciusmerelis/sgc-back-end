package com.basis.sgc.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.basis.sgc.domain.Status;
import com.basis.sgc.service.dto.StatusDto;

@Mapper(componentModel = "spring")
public interface StatusMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	StatusDto toDto(Status status);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	List<StatusDto> toDto(List<Status> status);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nome", target = "nome")
	Status toEntity(StatusDto statusDto);
}
