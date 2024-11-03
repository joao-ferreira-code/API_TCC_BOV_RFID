package api.Bov_Corte.Model.Bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "bovino_fazenda")
public class BovinoFazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_bovino_fazenda")
    private int pkBovinoFazenda;

    @Column(name = "fk_fazenda")
    private int fkFazenda;

    @Column(name = "fk_animal")
    private int fkAnimal;

    @Column(name = "fk_tag_rfid")
    private int fkTagRfid;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "tx_obtencao")
    private String txObtencao;

    @Column(name = "tx_baixa")
    private String txBaixa;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_baixa")
    private Date dtBaixa;

}