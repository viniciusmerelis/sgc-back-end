package com.basis.sgc.controller;

import com.basis.sgc.service.ColaboradorService;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @JsonView(Views.Listagem.class)
    @GetMapping
    public ResponseEntity<Page<ColaboradorDTO>> listar(Pageable pegeable) {
        return new ResponseEntity<>(colaboradorService.listar(pegeable), HttpStatus.OK);
    }

    @GetMapping("/{colaboradorId}")
    public ResponseEntity<ColaboradorDTO> buscar(@PathVariable Integer colaboradorId) {
        return new ResponseEntity<>(colaboradorService.buscarPorId(colaboradorId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> salvar(@RequestBody @Valid ColaboradorDTO colaboradorDTO) {
        return new ResponseEntity<>(colaboradorService.salvar(colaboradorDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ColaboradorDTO> atualizar(@RequestBody @Valid ColaboradorDTO colaboradorDTO) {
        colaboradorService.salvar(colaboradorDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{colaboradorId}")
    public ResponseEntity<?> excluir(@PathVariable Integer colaboradorId) {
        colaboradorService.excluir(colaboradorId);
        return ResponseEntity.noContent().build();
    }
}
