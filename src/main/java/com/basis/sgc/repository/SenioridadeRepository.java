package com.basis.sgc.repository;

import com.basis.sgc.domain.Senioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenioridadeRepository extends JpaRepository<Senioridade, Integer> {

}
