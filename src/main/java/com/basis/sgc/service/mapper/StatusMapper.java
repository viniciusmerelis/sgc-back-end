package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Status;
import com.basis.sgc.service.dto.StatusDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper extends EntityMapper<StatusDto, Status> {

}
