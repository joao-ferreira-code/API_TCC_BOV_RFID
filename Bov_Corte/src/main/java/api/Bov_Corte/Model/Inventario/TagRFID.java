package api.Bov_Corte.Model.Inventario;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "tag_rfid")
public class TagRFID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_tag_rfid")
    private int pkTagRfid;

    @Column(name = "fk_lote_tag")
    private int fkLoteTag;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "tx_codigo_EPC")
    private String txCodigoEpc;

    @Column(name = "tx_motivo_remocao")
    private String txMotivoRemocao;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_remocao")
    private Date dtRemocao;

}