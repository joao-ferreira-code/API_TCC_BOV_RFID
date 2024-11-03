package api.Bov_Corte.Model.AdmSistema;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "nivel_acesso")
public class NivelAcesso implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_nivel_acesso")
    private int pkNivelAcesso;

    @Column(name = "tx_nome")
    private String txNome;

    @Column(name = "tx_descricao_nivel_acesso")
    private String txDescricaoNivelAcesso;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

//----------------------------------- GrantedAuthority -----------------------------------//

    @Override
    public String getAuthority() {
        return "RULE_"+this.txNome.toUpperCase();
    }

//----------------------------------------------------------------------------------------//

}