package com.basis.sgc.exception.handler;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProblemDetail {
    private LocalDateTime timestamp;
    private String path;
    private Integer status;
    private String title;
    private String detail;
    private List<Propriedades> propriedades = new ArrayList<>();
}
