package com.basis.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.TurmaFormacao;

@Repository
public interface TurmaFormacaoRepository extends JpaRepository<TurmaFormacao, Integer>{

}
