package com.basis.sgc.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.basis.sgc.service.TurmaFormacaoService;
import com.basis.sgc.service.dto.TurmaFormacaoDto;
import com.basis.sgc.service.dto.input.TurmaFormacaoDtoInput;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/turmas")
@AllArgsConstructor
public class TurmaFormacaoController {

	private TurmaFormacaoService turmaFormacaoService;

	@GetMapping
	public ResponseEntity<List<TurmaFormacaoDto>> listarTodas() {
		return ResponseEntity.ok(turmaFormacaoService.listarTodas());
	}

	@GetMapping("/{turmaId}")
	public ResponseEntity<TurmaFormacaoDto> buscarPeloId(@PathVariable Integer turmaId) {
		return ResponseEntity.ok(turmaFormacaoService.buscarPeloId(turmaId));
	}

	@PostMapping
	public ResponseEntity<TurmaFormacaoDto> salvar(@RequestBody @Valid TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(turmaFormacaoService.salvar(turmaFormacaoDtoInput));
	}

	@PutMapping("/{turmaId}")
	public ResponseEntity<TurmaFormacaoDto> atualizar(@PathVariable Integer turmaId,
			@RequestBody @Valid TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
		return ResponseEntity.ok(turmaFormacaoService.atualizar(turmaId, turmaFormacaoDtoInput));
	}
	
	@DeleteMapping("/{turmaId}")
	public ResponseEntity<?> excluir(@PathVariable Integer turmaId) {
		turmaFormacaoService.excluir(turmaId);
		return ResponseEntity.noContent().build();
	}
}
