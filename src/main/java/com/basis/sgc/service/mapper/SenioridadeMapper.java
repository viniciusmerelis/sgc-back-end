package com.basis.sgc.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.service.dto.SenioridadeDto;

@Mapper(componentModel = "spring")
public interface SenioridadeMapper {

	SenioridadeDto toDto(Senioridade senioridade);
	
	List<SenioridadeDto> toDto(List<Senioridade> senioridade);
	
	Senioridade toEntity(SenioridadeDto senioridadeDto);
}
