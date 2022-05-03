package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.TurmaFormacao;
import com.basis.sgc.service.dto.TurmaFormacaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CompetenciaEColaboradorMapper.class)
public interface TurmaFormacaoMapper extends EntityMapper<TurmaFormacaoDTO, TurmaFormacao> {

}
