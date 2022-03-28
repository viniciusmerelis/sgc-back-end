package com.basis.sgc.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.domain.Status;
import com.basis.sgc.domain.TurmaCompetenciaColaborador;
import com.basis.sgc.domain.TurmaFormacao;
import com.basis.sgc.enums.Nivel;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.exception.RegraNegocioException;
import com.basis.sgc.repository.CompetenciaColaboradorRepository;
import com.basis.sgc.repository.TurmaFormacaoRepository;
import com.basis.sgc.service.dto.TurmaFormacaoDto;
import com.basis.sgc.service.dto.input.TurmaFormacaoDtoInput;
import com.basis.sgc.service.mapper.TurmaFormacaoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TurmaFormacaoService {

	private static final String MSG_TURMA_NAO_ENCONTRADA = "Não existe um cadastro dessa turma formação no sistema";
	private static final String MSG_ERRO_EXCLUIR_TURMA_INICIADA = "Esta turma não pode ser excluida pois está em andamento.";

	private final TurmaFormacaoRepository turmaFormacaoRepository;
	private final TurmaFormacaoMapper turmaFormacaoMapper;
	private final StatusService statusService;
	private final CompetenciaService competenciaService;
	private final ColaboradorService colaboradorService;
	private final CompetenciaColaboradorRepository competenciaColaboradorRepository;

	public List<TurmaFormacaoDto> listar() {
		return turmaFormacaoMapper.toDto(turmaFormacaoRepository.findAll());
	}

	public TurmaFormacaoDto buscarPorId(Integer turmaId) {
		return turmaFormacaoMapper.toDto(buscarOuFalhar(turmaId));
	}

	public TurmaFormacaoDto salvar(TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
		TurmaFormacao turma = turmaFormacaoMapper.toEntity(turmaFormacaoDtoInput);
		Integer statusId = turma.getStatus().getId();
		Status status = statusService.buscarOuFalhar(statusId);
		turma.setStatus(status);
		turma.setCompetenciasColaboradores(adicionarCompetenciasColaboradores(turma));
		return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turma));
	}

	public TurmaFormacaoDto atualizar(Integer turmaId, TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
		TurmaFormacao turma = turmaFormacaoMapper.toEntity(turmaFormacaoDtoInput);
		turma.setId(turmaId);
		Integer statusId = turma.getStatus().getId();
		Status status = statusService.buscarOuFalhar(statusId);
		turma.setStatus(status);
		turma.setCompetenciasColaboradores(adicionarCompetenciasColaboradores(turma));
		return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turma));
	}

	public void excluir(Integer turmaId) {
		TurmaFormacao turma = buscarOuFalhar(turmaId);
		if (turma.getStatus().getNome().equals("Iniciada")) {
			throw new RegraNegocioException(MSG_ERRO_EXCLUIR_TURMA_INICIADA);
		}
		turmaFormacaoRepository.deleteById(turmaId);
		turmaFormacaoRepository.flush();
	}

	public TurmaFormacao buscarOuFalhar(Integer turmaId) {
		return turmaFormacaoRepository.findById(turmaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_TURMA_NAO_ENCONTRADA + turmaId));
	}

	private Set<TurmaCompetenciaColaborador> adicionarCompetenciasColaboradores(TurmaFormacao turma) {
		turma.getCompetenciasColaboradores().forEach(item -> {
			Competencia competencia = competenciaService.buscarOuFalhar(item.getId().getCompetenciaId());
			Colaborador colaborador = colaboradorService.buscarOuFalhar(item.getId().getColaboradorId());
			if (!competenciaColaboradorRepository.existeCompetenciaColaboradorComNivel(competencia.getId(),
					colaborador.getId(), Nivel.SABE_ENSINAR)) {
				throw new RegraNegocioException(
						"O colaborador " + colaborador.getNome() + " " + colaborador.getSobrenome()
								+ ", não possuir nível 'Sabe ensinar' na competência " + competencia.getNome());
			}
			if (turma.getId() != null) {
				item.getId().setTurmaId(turma.getId());
			}
			item.setTurma(turma);
			item.setCompetencia(competencia);
			item.setColaborador(colaborador);

		});
		return turma.getCompetenciasColaboradores();
	}
}