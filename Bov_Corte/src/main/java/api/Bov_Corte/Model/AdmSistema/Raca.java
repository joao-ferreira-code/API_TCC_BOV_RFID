package api.Bov_Corte.Model.AdmSistema;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "raca_bolvino")
public class Raca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_raca")
    private int pkRaca;

    @Column(name = "tx_nome")
    private String txNome;

    @Column(name = "tx_descricao")
    private String txDescricao;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

}