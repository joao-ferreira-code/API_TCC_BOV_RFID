package api.Bov_Corte.Model.Inventario;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "vacina")
public class LoteVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_vacina")
    private int pkVacina;

    @Column(name = "fk_fazenda")
    private int fkFazenda;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "tx_nome_vacina")
    private String txNomeVacina;

    @Column(name = "tx_nome_lote_vacina")
    private String txNomeLoteVacina;

    @Column(name = "nr_custo")
    private int nrCusto;

    @Column(name = "nr_unidades")
    private int nrUnidades;

    @Column(name = "is_registrada_indagro")
    private boolean isRegistradaIndagro;

    @Column(name = "is_obrigatoria")
    private boolean isObrigatoria;

    @Column(name = "dt_vencimento")
    private String dtVencimento;

    @Column(name = "tx_observacao")
    private String txObservacao;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

}