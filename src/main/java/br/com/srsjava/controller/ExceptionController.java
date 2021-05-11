package br.com.srsjava.controller;

import br.com.srsjava.dto.ResponseErrorDto;
import br.com.srsjava.exceptions.ExceptionInternalServerError;
import br.com.srsjava.exceptions.ExceptionNotFound;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ControllerAdvice
public class ExceptionController extends RuntimeException{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDto> handle(MethodArgumentNotValidException ex) {
        ResponseErrorDto response = new ResponseErrorDto();
        response.setDateTimeError(LocalDateTime.now());
        response.setHttpError(HttpStatus.BAD_REQUEST.toString());
        ex.getBindingResult().getAllErrors().forEach(error -> {
            response.getErros().put(((FieldError) error).getField(),error.getDefaultMessage());
        });
        return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExceptionInternalServerError.class)
    public ResponseEntity<ResponseErrorDto> handler(ExceptionInternalServerError ex){
        ResponseErrorDto response = new ResponseErrorDto();
        response.setDateTimeError(LocalDateTime.now());
        response.setHttpError(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        ex.getErros().forEach(error -> {
            response.getErros().put(error.getErro(),ex.getError());
        });
        return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExceptionNotFound.class)
    public ResponseEntity<ResponseErrorDto> handler(ExceptionNotFound ex){
        ResponseErrorDto response = new ResponseErrorDto();
        response.setDateTimeError(LocalDateTime.now());
        response.setHttpError(HttpStatus.NOT_FOUND.toString());
        ex.getErros().forEach(error -> {
            response.getErros().put(error.getErro(),ex.getError());
        });
        return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }

}
