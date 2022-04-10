package com.basis.sgc.controller;

import com.basis.sgc.service.TurmaFormacaoService;
import com.basis.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.sgc.view.TurmaFormacaoView;
import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView(TurmaFormacaoView.Listagem.class)
    @GetMapping()
    public ResponseEntity<List<TurmaFormacaoDTO>> listar() {
        return new ResponseEntity<>(turmaFormacaoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{turmaId}")
    public ResponseEntity<TurmaFormacaoDTO> buscar(@PathVariable Integer turmaId) {
        return new ResponseEntity<>(turmaFormacaoService.buscarPorId(turmaId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid TurmaFormacaoDTO turmaFormacaoDTO) {
        turmaFormacaoService.salvar(turmaFormacaoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody @Valid TurmaFormacaoDTO turmaFormacaoDTO) {
        turmaFormacaoService.salvar(turmaFormacaoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{turmaId}")
    public ResponseEntity<?> excluir(@PathVariable Integer turmaId) {
        turmaFormacaoService.excluir(turmaId);
        return ResponseEntity.noContent().build();
    }
}
