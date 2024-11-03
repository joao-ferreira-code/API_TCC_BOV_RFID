package api.Bov_Corte.Model.Inventario;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "lote_teg_RFID")
public class LoteTagRFID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_lote_tag")
    private int pkLoteTag;

    @Column(name = "fk_fazenda")
    private int fkFazenda;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "nr_unidades")
    private int nrUnidades;

    @Column(name = "nr_valor_pago")
    private int nrValorPago;

    @Column(name = "is_metalica")
    private boolean isMetalica;

    @Column(name = "is_tamp_proof")
    private boolean isTampProof;

    @Column(name = "tx_frequencia_operacao")
    private String txFrequenciaOperacao;

    @Column(name = "tx_modelo_leitura")
    private String txModeloLeitura;

    @Column(name = "tx_senha_lote")
    private String txSenhaLote;

    @Column(name = "tx_observacao_resumo")
    private String txObservacaoResumo;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

}