package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.CompetenciaNivelDTO;
import com.basis.sgc.service.dto.input.ColaboradorDtoInput;
import com.basis.sgc.service.dto.input.CompetenciaNivelDtoIdInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CompetenciaColaboradorMapper.class)
public interface ColaboradorMapper extends EntityMapper<ColaboradorDTO, Colaborador> {

}
