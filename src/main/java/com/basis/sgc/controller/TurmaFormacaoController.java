package com.basis.sgc.controller;

import com.basis.sgc.service.TurmaFormacaoService;
import com.basis.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.sgc.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
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
@RequestMapping("/api/turmas")
@RequiredArgsConstructor
public class TurmaFormacaoController {

    private final TurmaFormacaoService turmaFormacaoService;

    @JsonView(Views.Listagem.class)
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
