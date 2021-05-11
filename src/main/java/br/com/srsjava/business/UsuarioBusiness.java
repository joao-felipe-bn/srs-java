package br.com.srsjava.business;

import br.com.srsjava.dto.UsuarioDto;
import br.com.srsjava.entity.UsuarioEntity;
import br.com.srsjava.exceptions.ExceptionInternalServerError;
import br.com.srsjava.exceptions.ExceptionNotFound;
import br.com.srsjava.repository.UsuarioRepository;
import enums.ERROS;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@Service
public class UsuarioBusiness {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDto inser(UsuarioDto dto){
        try {
            UsuarioEntity usuario = new UsuarioEntity(dto);
            usuario.setDataInclusao(new Date());
            usuario.setUsuarioId(null);
            return usuarioRepository.save(usuario).toDto();
        }catch (Exception e){
            throw new ExceptionInternalServerError(Arrays.asList(ERROS.ERRO_INSERIR_USUARIO),e.getMessage());
        }
    }

    public UsuarioDto update(UsuarioDto dto, Integer id){
        try {
            UsuarioEntity usuario = usuarioRepository.findById(BigInteger.valueOf(id)).get();
            dto.setUsuarioId(usuario.getUsuarioId());

            UsuarioEntity updatedUsuario = new UsuarioEntity(dto);
            updatedUsuario.setDataAlteracao(new Date());
            updatedUsuario.setDataInclusao(usuario.getDataInclusao());

            return usuarioRepository.save(updatedUsuario).toDto();
        }catch (Exception e){
            throw new ExceptionInternalServerError(Arrays.asList(ERROS.ERRO_ATUALIZAR_USUARIO),e.getMessage());
        }
    }

    public UsuarioDto getById(Integer id){
        try {
            return usuarioRepository.findById(BigInteger.valueOf(id)).get().toDto();
        } catch (NoSuchElementException noSuchElementException) {
            throw new ExceptionNotFound(Arrays.asList(ERROS.ERRO_AO_BUSCAR_USUARIO), noSuchElementException.getMessage());
        } catch (Exception e){
            throw new ExceptionInternalServerError(Arrays.asList(ERROS.ERRO_AO_BUSCAR_USUARIO),e.getMessage());
        }
    }

    public List<UsuarioDto> getAll(){
        try {
            return usuarioRepository.findAll().stream().map(e -> e.toDto()).collect(Collectors.toList());
        } catch (Exception e){
            throw new ExceptionInternalServerError(Arrays.asList(ERROS.ERRO_AO_BUSCAR_USUARIO),e.getMessage());
        }
    }

}
