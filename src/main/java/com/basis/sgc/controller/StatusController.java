package com.basis.sgc.controller;

import com.basis.sgc.service.StatusService;
import com.basis.sgc.service.dto.StatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @GetMapping
    public ResponseEntity<List<StatusDto>> listar() {
        return new ResponseEntity<>(statusService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{statusId}")
    public ResponseEntity<StatusDto> buscar(@PathVariable Integer statusId) {
        return new ResponseEntity<>(statusService.buscarPorId(statusId), HttpStatus.OK);
    }
}
