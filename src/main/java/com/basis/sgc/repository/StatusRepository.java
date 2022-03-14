package com.basis.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}
