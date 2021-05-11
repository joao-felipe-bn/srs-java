package br.com.srsjava.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.util.Date;

@Data
public class UsuarioDto {

    private BigInteger usuarioId;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Email é obrigatório")
    private String email;
    private String login;
    @NotBlank(message = "Senha é obrigatório")
    private String senha;
    private boolean situacao;
//    @NotBlank(message = "Data de nascimento é obrigatório")
    private Date dataNascimento;
    @NotBlank(message = "Identificador (CPF/CNPJ) é obrigatório")
    private String identificador;

}