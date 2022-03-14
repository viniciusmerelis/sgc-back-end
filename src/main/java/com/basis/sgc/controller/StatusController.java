package com.basis.sgc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basis.sgc.service.StatusService;
import com.basis.sgc.service.dto.StatusDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/status")
@AllArgsConstructor
public class StatusController {

	private StatusService statusService;
	
	@GetMapping
	public ResponseEntity<List<StatusDto>> listarTodas() {
		return ResponseEntity.ok(statusService.listarTodas());
	}
	
	@GetMapping("/{statusId}")
	public ResponseEntity<StatusDto> buscarPeloId(@PathVariable Integer statusId) {
		return ResponseEntity.ok(statusService.buscarPeloId(statusId));
	}
}
