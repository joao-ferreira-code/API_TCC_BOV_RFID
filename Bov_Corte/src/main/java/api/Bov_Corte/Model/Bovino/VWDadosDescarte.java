package api.Bov_Corte.Model.Bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "vw_dados_descarte")
public class VWDadosDescarte {

    @Id
    private int pkDescarteBovino;

    @Column(name = "fk_animal_fazenda")
    private int fkAnimalFazenda;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "fk_fazenda")
    private int fkFazenda;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_perca")
    private Date dtPerca;

    @Column(name = "tx_motivo")
    private String txMotivo;

    @Column(name = "tx_observacao")
    private String txObservacao;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

    @Column(name = "tx_nome")
    private String txNome;

    @Column(name = "tx_sexo")
    private String txSexo;

}