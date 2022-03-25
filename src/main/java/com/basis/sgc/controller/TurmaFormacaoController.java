package com.basis.sgc.controller;

import com.basis.sgc.service.TurmaFormacaoService;
import com.basis.sgc.service.dto.TurmaFormacaoDto;
import com.basis.sgc.service.dto.input.TurmaFormacaoDtoInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@RequiredArgsConstructor
public class TurmaFormacaoController {

    private final TurmaFormacaoService turmaFormacaoService;

    @GetMapping()
    public ResponseEntity<List<TurmaFormacaoDto>> listar() {
        return new ResponseEntity<>(turmaFormacaoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{turmaId}")
    public ResponseEntity<TurmaFormacaoDto> buscar(@PathVariable Integer turmaId) {
        return new ResponseEntity<>(turmaFormacaoService.buscarPorId(turmaId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TurmaFormacaoDto> salvar(@RequestBody @Valid TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
        return new ResponseEntity<>(turmaFormacaoService.salvar(turmaFormacaoDtoInput), HttpStatus.CREATED);
    }

    @PutMapping("/{turmaId}")
    public ResponseEntity<TurmaFormacaoDto> atualizar(@PathVariable Integer turmaId,
                                                      @RequestBody @Valid TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
        return new ResponseEntity<>(turmaFormacaoService.atualizar(turmaId, turmaFormacaoDtoInput), HttpStatus.OK);
    }

    @DeleteMapping("/{turmaId}")
    public ResponseEntity<?> excluir(@PathVariable Integer turmaId) {
        turmaFormacaoService.excluir(turmaId);
        return ResponseEntity.noContent().build();
    }
}
