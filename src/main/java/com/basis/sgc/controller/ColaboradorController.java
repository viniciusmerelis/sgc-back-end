package com.basis.sgc.controller;

import com.basis.sgc.service.ColaboradorService;
import com.basis.sgc.service.dto.ColaboradorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> listar() {
        return new ResponseEntity<>(colaboradorService.listar(), HttpStatus.OK);
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
