package com.basis.sgc.service;

import com.basis.sgc.domain.TurmaCompetenciaColaborador;
import com.basis.sgc.domain.TurmaFormacao;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.exception.RegraNegocioException;
import com.basis.sgc.repository.TurmaFormacaoRepository;
import com.basis.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.sgc.service.mapper.TurmaFormacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class TurmaFormacaoService {

    private static final String MSG_TURMA_NAO_ENCONTRADA = "Não existe um cadastro dessa turma formação no sistema";
    private static final String MSG_ERRO_EXCLUIR_TURMA_INICIADA = "Esta turma não pode ser excluida pois está em andamento.";

    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoMapper turmaFormacaoMapper;

    public Page<TurmaFormacaoDTO> listar(Pageable pageable) {
        Page<TurmaFormacao> turmasPages = turmaFormacaoRepository.findAll(pageable);
        List<TurmaFormacaoDTO> turmasDTO = turmaFormacaoMapper.toDto(turmasPages.getContent());
        Page<TurmaFormacaoDTO> turmasPagesDTO = new PageImpl<>(turmasDTO, pageable, turmasPages.getTotalElements());
        return turmasPagesDTO;
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
                .orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_TURMA_NAO_ENCONTRADA + turmaId));
    }

    private Set<TurmaCompetenciaColaborador> adicionarCompetenciasColaboradores(TurmaFormacao turma) {
        turma.getCompetenciasEColaboradores().forEach(item -> {
            if (turma.getId() != null) {
                item.getId().setTurmaId(turma.getId());
            }
            item.setTurma(turma);
        });
        return turma.getCompetenciasEColaboradores();
    }
}
