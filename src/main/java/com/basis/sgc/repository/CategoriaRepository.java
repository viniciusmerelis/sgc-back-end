package com.basis.sgc.repository;

import com.basis.sgc.service.dto.SelectItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    @Query(value = "select new com.basis.sgc.service.dto.SelectItemDto(c.id, c.nome) from Categoria c")
    List<SelectItemDto> buscarCategoriasSelectItem();
}
