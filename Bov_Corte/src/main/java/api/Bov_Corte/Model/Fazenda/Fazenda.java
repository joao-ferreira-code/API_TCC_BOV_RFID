package api.Bov_Corte.Model.Fazenda;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "fazenda")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_fazenda")
    private int pkFazenda;

    @Column(name = "tx_codigo_publico")
    private String txCodigoPublico;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "fk_cidade")
    private int fkCidade;

    @Column(name = "tx_nome")
    private String txNome;

    @Column(name = "nr_total_hectares")
    private double nrTotalHectares;

    @Column(name = "tx_telefone")
    private String txTelefone;

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

    @Transient
    private byte[] btFotoFazenda;

}