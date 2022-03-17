package com.basis.sgc.exception.handler;

import com.basis.sgc.exception.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<?> handleRegraNegocio(RegraNegocioException ex, WebRequest request) {
        ProblemDetail problemDetail = new ProblemDetail();
        ProblemType problemType = ProblemType.ERRO_NEGOCIO;
        problemDetail.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetail.setTitle(problemType.getTitle());
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setPath(problemType.getUri());
        problemDetail.setTimestamp(LocalDateTime.now());
        return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                           HttpHeaders headers, HttpStatus status,
                                                                           WebRequest request) {

        ProblemDetail problemDetail = new ProblemDetail();
        ProblemType problemType = ProblemType.DADOS_INVALIDOS;
        problemDetail.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetail.setTitle(problemType.getTitle());
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setPath(problemType.getUri());
        problemDetail.setTimestamp(LocalDateTime.now());

        List<Propriedades> propriedades = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    Propriedades field = new Propriedades();
                    field.setNome(fieldError.getField());
                    field.setUserMessage(fieldError.getDefaultMessage());
                    return field;
                })
                .collect(Collectors.toList());

        problemDetail.setPropriedades(propriedades);

        return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
