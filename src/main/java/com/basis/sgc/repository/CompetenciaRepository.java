package com.basis.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.Competencia;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer>{

}