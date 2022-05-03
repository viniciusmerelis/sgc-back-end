package com.basis.sgc.service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.domain.TurmaCompetenciaColaborador;
import com.basis.sgc.domain.TurmaFormacao;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.exception.RegraNegocioException;
import com.basis.sgc.repository.TurmaFormacaoRepository;
import com.basis.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.sgc.service.mapper.TurmaFormacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class TurmaFormacaoService {

    private static final String MSG_TURMA_NAO_ENCONTRADA = "Não existe um cadastro de turma formação no sistema com código %d";
    private static final String MSG_ERRO_EXCLUIR_TURMA_INICIADA = "Esta turma não pode ser excluida pois está em andamento.";

    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoMapper turmaFormacaoMapper;
    private final CompetenciaService competenciaService;
    private final ColaboradorService colaboradorService;

    public List<TurmaFormacaoDTO> listar() {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.findAll());
    }

    public TurmaFormacaoDTO buscarPorId(Integer turmaId) {
        return turmaFormacaoMapper.toDto(buscar(turmaId));
    }

    public TurmaFormacaoDTO salvar(TurmaFormacaoDTO turmaFormacaoDTO) {
        TurmaFormacao turma = turmaFormacaoMapper.toEntity(turmaFormacaoDTO);
        turma.setCompetenciasEColaboradores(adicionarCompetenciasColaboradores(turma));
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turma));
    }

    public void excluir(Integer turmaId) {
        TurmaFormacao turma = buscar(turmaId);
        if (turma.getStatus().getNome().equals("Iniciada")) {
            throw new RegraNegocioException(MSG_ERRO_EXCLUIR_TURMA_INICIADA);
        }
        turmaFormacaoRepository.deleteById(turmaId);
    }

    public TurmaFormacao buscar(Integer turmaId) {
        return turmaFormacaoRepository.findById(turmaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_TURMA_NAO_ENCONTRADA, turmaId)));
    }

    private Set<TurmaCompetenciaColaborador> adicionarCompetenciasColaboradores(TurmaFormacao turma) {
        turma.getCompetenciasEColaboradores().forEach(item -> {
            if (turma.getId() != null) {
                item.getId().setTurmaId(turma.getId());
            }
            Competencia competencia = competenciaService.buscar(item.getCompetencia().getId());
            Colaborador colaborador = colaboradorService.buscar(item.getColaborador().getId());
            item.setTurma(turma);
            item.setCompetencia(competencia);
            item.setColaborador(colaborador);
        });
        return turma.getCompetenciasEColaboradores();
    }
}
