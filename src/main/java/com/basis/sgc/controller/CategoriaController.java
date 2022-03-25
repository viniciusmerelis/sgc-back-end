package com.basis.sgc.controller;

import com.basis.sgc.service.CategoriaService;
import com.basis.sgc.service.dto.CategoriaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listar() {
        return new ResponseEntity<>(categoriaService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriaDto> buscar(@PathVariable Integer categoriaId) {
        return new ResponseEntity<>(categoriaService.buscarPorId(categoriaId), HttpStatus.OK);
    }
}
