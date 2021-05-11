package br.com.srsjava.controller;

import br.com.srsjava.business.UsuarioBusiness;
import br.com.srsjava.dto.UsuarioDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/user")
@RestController
@Api(value = "Usuários")
public class UsuarioController {

    private final UsuarioBusiness business;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Integer id){
        return new ResponseEntity(business.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> insert(@Valid @RequestBody UsuarioDto dto){
        return new ResponseEntity(business.inser(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@Valid @RequestBody UsuarioDto dto, @PathVariable Integer id){
        return new ResponseEntity(business.update(dto,id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAll(){
        return new ResponseEntity(business.getAll(),HttpStatus.OK);
    }

}
