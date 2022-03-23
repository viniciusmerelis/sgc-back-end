package com.basis.sgc.controller;

import com.basis.sgc.service.TurmaFormacaoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turmas/{turmaId}/competencias-colaboradores")
@NoArgsConstructor
@AllArgsConstructor
public class TurmaCompetenciaColaboradorController {

    private TurmaFormacaoService turmaFormacaoService;

    @PutMapping("/competencias/{competenciaId}/colaboradores/{colaboradorId}")
    public void associar(@PathVariable Integer turmaId, @PathVariable Integer competenciaId,
                         @PathVariable Integer colaboradorId) {
        turmaFormacaoService.associarCompetenciaColaborador(turmaId, competenciaId, colaboradorId);
    }

}
