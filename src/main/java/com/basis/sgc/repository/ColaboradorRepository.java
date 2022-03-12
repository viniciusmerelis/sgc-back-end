package com.basis.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{

}
