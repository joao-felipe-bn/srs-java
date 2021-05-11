package br.com.srsjava.exceptions;


import enums.ERROS;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExceptionInternalServerError extends RuntimeException{

    private List<ERROS> erros = new ArrayList<>();
    private String error;

    public ExceptionInternalServerError(List<ERROS> erros, String erro){
        this.erros = erros;
        this.error = erro;
    }

    public ExceptionInternalServerError(){}

}
