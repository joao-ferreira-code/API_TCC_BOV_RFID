package api.Bov_Corte.Model.AdmSistema;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_estado")
    private int pkEstado;

    @Column(name = "tx_nome")
    private String txNome;

    @Column(name = "tx_sigla")
    private String txSigla;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

}