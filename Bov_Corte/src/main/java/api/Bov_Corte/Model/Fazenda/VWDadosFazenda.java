package api.Bov_Corte.Model.Fazenda;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "vw_dados_fazenda")
public class VWDadosFazenda {

    @Id
    @Column(name = "pk_fazenda")
    private int pkFazenda;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "fk_cidade")
    private int fkCidade;

    @Column(name = "tx_nome")
    private String txNome;

    @Column(name = "nr_total_hectares")
    private int nrTotalHectares;

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

    @Column(name = "tx_telefone")
    private String txTelefone;

    @Column(name = "tx_codigo_publico")
    private String txCodigoPublico;

    @Column(name = "cid_tx_nome")
    private String cidTxNome;

    @Column(name = "tx_Sigla")
    private String txSigla;

}