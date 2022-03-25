package com.basis.sgc.controller;

import com.basis.sgc.service.ColaboradorService;
import com.basis.sgc.service.dto.ColaboradorDto;
import com.basis.sgc.service.dto.input.ColaboradorDtoInput;
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
    public ResponseEntity<List<ColaboradorDto>> listar() {
        return new ResponseEntity<>(colaboradorService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{colaboradorId}")
    public ResponseEntity<ColaboradorDto> buscar(@PathVariable Integer colaboradorId) {
        return new ResponseEntity<>(colaboradorService.buscarPorId(colaboradorId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ColaboradorDto> salvar(@RequestBody @Valid ColaboradorDtoInput colaboradorDtoInput) {
        return new ResponseEntity<>(colaboradorService.salvar(colaboradorDtoInput), HttpStatus.CREATED);
    }

    @PutMapping("/{colaboradorId}")
    public ResponseEntity<ColaboradorDto> atualizar(@PathVariable Integer colaboradorId,
                                                    @RequestBody @Valid ColaboradorDtoInput colaboradorDtoInput) {
        return new ResponseEntity<>(colaboradorService.atualizar(colaboradorId, colaboradorDtoInput), HttpStatus.OK);
    }

    @DeleteMapping("/{colaboradorId}")
    public ResponseEntity<?> excluir(@PathVariable Integer colaboradorId) {
        colaboradorService.excluir(colaboradorId);
        return ResponseEntity.noContent().build();
    }
}
