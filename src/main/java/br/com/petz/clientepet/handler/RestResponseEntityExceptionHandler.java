package br.com.petz.clientepet.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorApiResponse> handlerApiException(ApiException ex, HttpServletRequest request) {
        log.error("[erro] - {} - {}", ex.getClass().getSimpleName(), ex.getMessage());

        ErrorApiResponse errorApiResponse = ErrorApiResponse.builder()
                .status(ex.getHttpStatus().value())
                .message(ex.getMessage())
                .error(ex.getHttpStatus().getReasonPhrase())
                .description(ex.getDescription())
                .path(request.getMethod() + ": " + request.getRequestURI())
                .build();
        return ResponseEntity.status(ex.getHttpStatus()).body(errorApiResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApiResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        log.error("[erro] - {} - {}", ex.getClass().getSimpleName(), ex.getMessage());

        ErrorApiResponse errorApiResponse = ErrorApiResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getBindingResult().getFieldErrors()
                        .stream()
                        .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                        .collect(Collectors.joining(" | ")))
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .description("Request body inválido!")
                .path(request.getMethod() + ": " + request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorApiResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorApiResponse> handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.error("[erro] - {} - {}", ex.getClass().getSimpleName(), ex.getMessage());

        ErrorApiResponse errorApiResponse = ErrorApiResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage().split(":")[0])
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .description("Request body inválido ou inexistente!")
                .path(request.getMethod() + ": " + request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorApiResponse);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApiResponse> genericException(Exception ex, HttpServletRequest request) {

        log.error("[erro] - {} - {}", ex.getClass().getSimpleName(), ex.getMessage());
        ErrorApiResponse errorApiResponse = ErrorApiResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage().split(":")[0])
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .description("Entre em contato com o suporte se o problema persistir")
                .path(request.getMethod() + ": " + request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorApiResponse);
    }

}
