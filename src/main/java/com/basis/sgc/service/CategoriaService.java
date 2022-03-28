package com.basis.sgc.service;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.service.dto.CategoriaDto;
import com.basis.sgc.service.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaService {

    private static final String MSG_CATEGORIA_NAO_ENCOTRADA = "Categoria de código %d não encontrada ";

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public List<CategoriaDto> listar() {
        return categoriaMapper.toDto(categoriaRepository.findAll());
    }

    public CategoriaDto buscarPorId(Integer categoriaId) {
        return categoriaMapper.toDto(buscar(categoriaId));
    }

    public Categoria buscar(Integer categoriaId) {
        return categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_CATEGORIA_NAO_ENCOTRADA, categoriaId)));
    }
}
