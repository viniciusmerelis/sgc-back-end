package com.basis.sgc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.basis.sgc.service.ColaboradorService;
import com.basis.sgc.service.dto.ColaboradorDto;
import com.basis.sgc.service.dto.CompetenciaColaboradorNivelMaximoDto;
import com.basis.sgc.service.dto.input.ColaboradorDtoInput;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/colaboradores")
@AllArgsConstructor
public class ColaboradorController {

	private ColaboradorService colaboradorService;
	
	@GetMapping
	public ResponseEntity<List<ColaboradorDto>> listarTodos() {
		return ResponseEntity.ok(colaboradorService.listarTodos());
	}
	
	@GetMapping("/{colaboradorId}")
	public ResponseEntity<ColaboradorDto> buscarPeloId(@PathVariable Integer colaboradorId) {
		return ResponseEntity.ok(colaboradorService.buscarPeloId(colaboradorId));
	}
	
	@PostMapping
	public ResponseEntity<ColaboradorDto> salvar(@RequestBody @Valid ColaboradorDtoInput colaboradorDtoInput) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(colaboradorService.salvar(colaboradorDtoInput));
	}
	
	@PutMapping("/{colaboradorId}")
	public ResponseEntity<ColaboradorDto> atualizar(@PathVariable Integer colaboradorId,
			@RequestBody @Valid ColaboradorDtoInput colaboradorDtoInput) {
		return ResponseEntity.ok(colaboradorService.atualizar(colaboradorId, colaboradorDtoInput));
	}
	
	@DeleteMapping("/{colaboradorId}")
	public ResponseEntity<?> excluir(@PathVariable Integer colaboradorId) {
		colaboradorService.excluir(colaboradorId);
		return ResponseEntity.noContent().build();
	}
}
