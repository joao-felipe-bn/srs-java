package br.com.srsjava.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseErrorDto {

    private String httpError;
    private LocalDateTime dateTimeError;
    private Map<String, String> erros = new HashMap<>();
}
