package com.basis.sgc.controller;

import com.basis.sgc.service.CompetenciaService;
import com.basis.sgc.service.dto.CompetenciaColaboradorNivelMaximoDto;
import com.basis.sgc.service.dto.CompetenciaDto;
import com.basis.sgc.service.dto.input.CompetenciaDtoInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competencias")
@RequiredArgsConstructor
public class CompetenciaController {

    private final CompetenciaService competenciaService;

    @GetMapping
    public ResponseEntity<List<CompetenciaDto>> listarTodas() {
        return new ResponseEntity<>(competenciaService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{competenciaId}")
    public ResponseEntity<CompetenciaDto> buscarPeloId(@PathVariable Integer competenciaId) {
        return new ResponseEntity<>(competenciaService.buscarPorId(competenciaId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompetenciaDto> salvar(@RequestBody @Valid CompetenciaDtoInput competenciaDtoInput) {
        return new ResponseEntity<>(competenciaService.salvar(competenciaDtoInput), HttpStatus.CREATED);
    }

    @PutMapping("/{competenciaId}")
    public ResponseEntity<CompetenciaDto> atualizar(@PathVariable Integer competenciaId,
                                                    @RequestBody @Valid CompetenciaDtoInput competenciaDtoInput) {
        return new ResponseEntity<>(competenciaService.atualizar(competenciaId, competenciaDtoInput), HttpStatus.OK);
    }

    @DeleteMapping("/{competenciaId}")
    public ResponseEntity<?> excluir(@PathVariable Integer competenciaId) {
        competenciaService.excluir(competenciaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(params = "colaboradores=nivel-maximo")
    public ResponseEntity<List<CompetenciaColaboradorNivelMaximoDto>> buscarColaboradoresNivelMaximo() {
        return new ResponseEntity<>(competenciaService.buscarColaboradoresNivelMaximo(), HttpStatus.OK);
    }
}
