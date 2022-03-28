package com.basis.sgc.service;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.exception.EntidadeEmUsoException;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.service.dto.*;
import com.basis.sgc.service.dto.input.CompetenciaDtoInput;
import com.basis.sgc.service.mapper.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetenciaService {

    private static final String MSG_COMPETENCIA_NAO_ENCONTRADA = "Não existe um cadastro dessa competencia no sistema.";
    private static final String MSG_COMPETENCIA_EM_USO = "Essa competência está em uso";

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;
    private final CategoriaService categoriaService;

    public List<CompetenciaDTO> listar() {
        return competenciaMapper.toDto(competenciaRepository.findAll());
    }

    public CompetenciaDTO buscarPorId(Integer competenciaId) {
        return competenciaMapper.toDto(buscar(competenciaId));
    }

    public CompetenciaDTO salvar(CompetenciaDtoInput competenciaDtoInput) {
        Competencia competencia = competenciaMapper.toEntity(competenciaDtoInput);
        Integer categoriaId = competencia.getCategoria().getId();
        Categoria categoria = categoriaService.buscar(categoriaId);
        competencia.setCategoria(categoria);
        return competenciaMapper.toDto(competenciaRepository.save(competencia));
    }

    public CompetenciaDTO atualizar(Integer competenciaId, CompetenciaDtoInput competenciaDtoInput) {
        Competencia competencia = competenciaMapper.toEntity(competenciaDtoInput);
        competencia.setId(competenciaId);
        Integer categoriaId = competencia.getCategoria().getId();
        Categoria categoria = categoriaService.buscar(categoriaId);
        competencia.setCategoria(categoria);
        return competenciaMapper.toDto(competenciaRepository.save(competencia));
    }

    public void excluir(Integer competenciaId) {
        try {
            competenciaRepository.deleteById(competenciaId);
            competenciaRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(MSG_COMPETENCIA_NAO_ENCONTRADA);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(MSG_COMPETENCIA_EM_USO);
        }
    }

    public Competencia buscar(Integer competenciaId) {
        return competenciaRepository.findById(competenciaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_COMPETENCIA_NAO_ENCONTRADA));
    }

    public List<CompetenciaColaboradorNivelMaximoDTO> buscarColaboradoresNivelMaximo() {
        List<CompetenciaColaboradorNivelMaximoListDTO> resultQuery = competenciaRepository.buscarCompetenciasEColaboradoresNivelMaximo();
        Map<Integer, CompetenciaColaboradorNivelMaximoDTO> map = new HashMap<>();

        for (CompetenciaColaboradorNivelMaximoListDTO itemResult : resultQuery) {
            CompetenciaColaboradorNivelMaximoDTO competenciaKey = map.computeIfAbsent(itemResult.getCompetenciaId(), (k) -> {
                CompetenciaColaboradorNivelMaximoDTO competencia = new CompetenciaColaboradorNivelMaximoDTO();
                competencia.setCompetencia(new CompetenciaResumoDTO());
                competencia.getCompetencia().setId(itemResult.getCompetenciaId());
                competencia.getCompetencia().setNome(itemResult.getCompetenciaNome());
                return competencia;
            });
            ColaboradorResumoDTO colaborador = new ColaboradorResumoDTO();
            colaborador.setId(itemResult.getColaboradorId());
            colaborador.setNome(itemResult.getColaboradorNome());
            colaborador.setSobrenome(itemResult.getColaboradorSobrenome());
            competenciaKey.getColaboradores().add(colaborador);
        }
        return new ArrayList<>(map.values());
    }
}
