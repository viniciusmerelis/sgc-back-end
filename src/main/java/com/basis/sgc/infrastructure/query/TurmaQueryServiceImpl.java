package com.basis.sgc.infrastructure.query;

import com.basis.sgc.domain.TurmaFormacao;
import com.basis.sgc.service.TurmaQueryService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TurmaQueryServiceImpl implements TurmaQueryService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<TurmaFormacao> consultarTurmaFormacao() {
        return null;
    }
}
