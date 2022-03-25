package com.basis.sgc.repository;

import com.basis.sgc.domain.TurmaFormacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaFormacaoRepository extends JpaRepository<TurmaFormacao, Integer> {

}
