package com.basis.sgc.service.mapper;

import java.util.List;

import com.basis.sgc.service.dto.StatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.basis.sgc.domain.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper extends EntityMapper<StatusDTO, Status> {

}
