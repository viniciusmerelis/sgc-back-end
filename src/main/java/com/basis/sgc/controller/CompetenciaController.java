package com.basis.sgc.controller;

import com.basis.sgc.service.CompetenciaService;
import com.basis.sgc.service.dto.ColaboradorResumoDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competencias")
@RequiredArgsConstructor
public class CompetenciaController {

    private final CompetenciaService competenciaService;

    @GetMapping
    public ResponseEntity<List<CompetenciaDTO>> listarTodas() {
        return new ResponseEntity<>(competenciaService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{competenciaId}")
    public ResponseEntity<CompetenciaDTO> buscarPeloId(@PathVariable Integer competenciaId) {
        return new ResponseEntity<>(competenciaService.buscarPorId(competenciaId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid CompetenciaDTO competenciaDTO) {
        competenciaService.salvar(competenciaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody @Valid CompetenciaDTO competenciaDTO) {
        competenciaService.salvar(competenciaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{competenciaId}")
    public ResponseEntity<?> excluir(@PathVariable Integer competenciaId) {
        competenciaService.excluir(competenciaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{competenciaId}", params = "colaboradores=nivel-maximo")
    public ResponseEntity<List<ColaboradorResumoDTO>> buscarColaboradoresComNivelMaximoNaCompetencia(@PathVariable Integer competenciaId) {
        return new ResponseEntity<>(competenciaService.buscarColaboradoresComNivelMaximoNaCompetencia(competenciaId), HttpStatus.OK);
    }
}
