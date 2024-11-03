package api.Bov_Corte.Model.Fazenda;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "colaborador_fazenda")
public class ColaboradorFazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_colaborador_fazenda")
    private int pkColaboradorFazenda;

    @Column(name = "fk_fazenda")
    private int fkFazenda;

    @Column(name = "fk_usuario")
    private int fkUsuario;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "fk_nivel_acesso")
    private int fkNivelAcesso;

    @Column(name = "tx_motivo_saida")
    private String txMotivoSaida;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_remocao")
    private Date dtRemocao;

}