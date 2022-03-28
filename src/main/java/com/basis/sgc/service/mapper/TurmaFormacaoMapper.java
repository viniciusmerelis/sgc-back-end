package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.TurmaCompetenciaColaborador;
import com.basis.sgc.domain.TurmaFormacao;
import com.basis.sgc.service.dto.CompetenciaColaboradorDTO;
import com.basis.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.sgc.service.dto.input.CompetenciaColaboradorDtoIdInput;
import com.basis.sgc.service.dto.input.TurmaFormacaoDtoInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaFormacaoMapper {

    @Mapping(source = "status.nome", target = "statusNome")
    TurmaFormacaoDTO toDto(TurmaFormacao turmaFormacao);

    @Mapping(source = "status.id", target = "status.id")
    @Mapping(source = "status.nome", target = "status.nome")
    List<TurmaFormacaoDTO> toDto(List<TurmaFormacao> turmaFormacao);

    @Mapping(source = "statusId", target = "status.id")
    @Mapping(target = "id", ignore = true)
    TurmaFormacao toEntity(TurmaFormacaoDtoInput turmaFormacaoDtoInput);

    @Mapping(source = "competenciaId", target = "id.competenciaId")
    @Mapping(source = "colaboradorId", target = "id.colaboradorId")
    @Mapping(target = "turma", ignore = true)
    @Mapping(target = "competencia", ignore = true)
    @Mapping(target = "colaborador", ignore = true)
    TurmaCompetenciaColaborador toTurmaCompetenciaColaboradorEntity(CompetenciaColaboradorDtoIdInput competenciaColaboradorDtoIdInput);

    @Mapping(source = "id.competenciaId", target = "competencia.id")
    @Mapping(source = "id.colaboradorId", target = "colaborador.id")
    @Mapping(source = "competencia.nome", target = "competencia.nome")
    @Mapping(source = "colaborador.nome", target = "colaborador.nome")
    CompetenciaColaboradorDTO toCompetenciaColaboradorDto(TurmaCompetenciaColaborador turmaCompetenciaColaborador);
}
