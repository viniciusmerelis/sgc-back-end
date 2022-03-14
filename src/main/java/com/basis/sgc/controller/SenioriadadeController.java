package com.basis.sgc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basis.sgc.service.SenioridadeService;
import com.basis.sgc.service.dto.SenioridadeDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/senioridades")
@AllArgsConstructor
public class SenioriadadeController {

	private SenioridadeService senioridadeService;
	
	@GetMapping
	public ResponseEntity<List<SenioridadeDto>> listarTodas() {
		return ResponseEntity.ok(senioridadeService.listarTodas());
	}
	
	@GetMapping("/{senioridadeId}")
	public ResponseEntity<SenioridadeDto> buscarPeloId(@PathVariable Integer senioridadeId) {
		return ResponseEntity.ok(senioridadeService.buscarPeloId(senioridadeId));
	}
}
