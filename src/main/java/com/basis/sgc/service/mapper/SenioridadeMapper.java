package com.basis.sgc.service.mapper;

import java.util.List;

import com.basis.sgc.service.dto.SenioridadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.basis.sgc.domain.Senioridade;

@Mapper(componentModel = "spring")
public interface SenioridadeMapper extends EntityMapper<SenioridadeDTO, Senioridade> {

}
