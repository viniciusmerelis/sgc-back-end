package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.service.dto.SenioridadeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SenioridadeMapper extends EntityMapper<SenioridadeDto, Senioridade> {

}
