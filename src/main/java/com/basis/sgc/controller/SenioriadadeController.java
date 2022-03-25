package com.basis.sgc.controller;

import com.basis.sgc.service.SenioridadeService;
import com.basis.sgc.service.dto.SenioridadeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/senioridades")
@RequiredArgsConstructor
public class SenioriadadeController {

    private final SenioridadeService senioridadeService;

    @GetMapping
    public ResponseEntity<List<SenioridadeDto>> listar() {
        return new ResponseEntity<>(senioridadeService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{senioridadeId}")
    public ResponseEntity<SenioridadeDto> buscar(@PathVariable Integer senioridadeId) {
        return new ResponseEntity<>(senioridadeService.buscarPorId(senioridadeId), HttpStatus.OK);
    }
}
