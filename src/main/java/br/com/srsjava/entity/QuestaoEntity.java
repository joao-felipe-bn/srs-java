package br.com.srsjava.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity(name = "questao")
public class QuestaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questao_id")
    private BigInteger questaoId;
    @Column(name = "pergunta")
    private String pergunta;
    @Column(name = "resposta")
    private String resposta;
    @Column(name = "data_inclusao")
    private Date dataInclusao;
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

//    @ManyToOne
//    @JoinColumn(name="usuario_id")
//    @Column(name = "usuario_id")
//    private UsuarioEntity usuarioEntity;
}
