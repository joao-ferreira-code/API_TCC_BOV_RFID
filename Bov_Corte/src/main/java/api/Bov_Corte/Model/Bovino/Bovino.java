package api.Bov_Corte.Model.Bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "bovino")
public class Bovino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_bovino")
    private int pkBovino;

    @Column(name = "fk_bovino_matriz_femea")
    private int fkBovinoMatrizFemea;

    @Column(name = "fk_bovino_matriz_macho")
    private int fkBovinoMatrizMacho;

    @Column(name = "fk_raca")
    private int fkRaca;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "tx_sexo")
    private String txSexo;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_nascimento")
    private Date dtNascimento;

    @Column(name = "tx_grau_sangue")
    private String txGrauSangue;

    @Column(name = "is_inseminacao")
    private boolean isInseminacao;

    @Column(name = "tx_avaliacao")
    private String txAvaliacao;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

}