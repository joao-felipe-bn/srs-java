package br.com.srsjava.controller;

import io.swagger.annotations.Api;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RequiredArgsConstructor
@RequestMapping(value = "/questao")
@RestController
@Api(value = "Questões")
public class QuestaoController {

}
