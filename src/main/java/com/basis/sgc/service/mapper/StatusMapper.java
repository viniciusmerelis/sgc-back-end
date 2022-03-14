package com.basis.sgc.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.basis.sgc.domain.Status;
import com.basis.sgc.service.dto.StatusDto;

@Mapper(componentModel = "spring")
public interface StatusMapper {

	StatusDto toDto(Status status);
	
	List<StatusDto> toDto(List<Status> status);
	
	Status toEntity(StatusDto statusDto);
}
