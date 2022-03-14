package com.basis.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.Senioridade;

@Repository
public interface SenioridadeRepository extends JpaRepository<Senioridade, Integer>{

}
