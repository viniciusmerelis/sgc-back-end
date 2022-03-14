package com.basis.sgc.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.service.dto.ColaboradorDto;
import com.basis.sgc.service.dto.CompetenciaResumoDto;
import com.basis.sgc.service.dto.input.ColaboradorDtoInput;
import com.basis.sgc.service.dto.input.CompetenciaDtoIdInput;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {

	@Mapping(source = "senioridade.id", target = "senioridade.id")
	@Mapping(source = "senioridade.nome", target = "senioridade.nome")
	ColaboradorDto toDto(Colaborador colaborador);
	
	@Mapping(source = "senioridade.id", target = "senioridade.id")
	@Mapping(source = "senioridade.nome", target = "senioridade.nome")
	List<ColaboradorDto> toDto(List<Colaborador> colaborador);
	
	@Mapping(source = "senioridadeId", target = "senioridade.id")
	@Mapping(target = "id", ignore = true)
	Colaborador toEntity(ColaboradorDtoInput colaboradorDtoInput);
	
	@Mapping(source = "id", target = "id.competenciaId")
	@Mapping(target = "competencia", ignore = true)
	@Mapping(target = "colaborador", ignore = true)
	@Mapping(target = "nivel", ignore = true)
	CompetenciaColaborador toCompetenciaColaboradorEntity(CompetenciaDtoIdInput competenciaDtoIdInput);
	
	@Mapping(source = "id.competenciaId", target = "id")
	@Mapping(source =  "competencia.nome", target = "nome")
	CompetenciaResumoDto toCompetenciaResumoDto(CompetenciaColaborador competenciaColaborador);
}
