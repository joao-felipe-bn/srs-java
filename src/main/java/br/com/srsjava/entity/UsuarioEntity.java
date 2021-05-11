package br.com.srsjava.entity;

import br.com.srsjava.dto.UsuarioDto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "usuario")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private BigInteger usuarioId;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "situacao")
    private boolean situacao;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "identificador")
    private String identificador;
    @Column(name = "data_inclusao")
    private Date dataInclusao;
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

//    @OneToMany(mappedBy="questao")
//    private List<QuestaoEntity> questoes = new ArrayList<QuestaoEntity>();

    public UsuarioEntity(){}

    public UsuarioEntity(UsuarioDto usuarioDto){
        this.usuarioId = usuarioDto.getUsuarioId();
        this.nome = usuarioDto.getNome();
        this.email = usuarioDto.getEmail();
        this.login = usuarioDto.getLogin();
        this.senha = usuarioDto.getSenha();
        this.situacao = usuarioDto.isSituacao();
        this.dataNascimento = usuarioDto.getDataNascimento();
        this.identificador = usuarioDto.getIdentificador();
    }

    public UsuarioDto toDto(){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setUsuarioId(this.usuarioId);
        usuarioDto.setNome(this.nome);
        usuarioDto.setEmail(this.email);
        usuarioDto.setLogin(this.login);
        usuarioDto.setSenha(this.senha);
        usuarioDto.setSituacao(this.situacao);
        usuarioDto.setDataNascimento(this.dataNascimento);
        usuarioDto.setIdentificador(this.identificador);
        return usuarioDto;
    }

}

