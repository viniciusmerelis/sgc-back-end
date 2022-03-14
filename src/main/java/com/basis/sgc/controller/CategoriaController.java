package com.basis.sgc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basis.sgc.service.CategoriaService;
import com.basis.sgc.service.dto.CategoriaDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categorias")
@AllArgsConstructor
public class CategoriaController {

	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDto>> listarTodas() {
		return ResponseEntity.ok(categoriaService.listarTodas());
	}
	
	@GetMapping("/{categoriaId}")
	public ResponseEntity<CategoriaDto> buscarPeloId(@PathVariable Integer categoriaId) {
		return ResponseEntity.ok(categoriaService.buscarPeloId(categoriaId));
	}
}
