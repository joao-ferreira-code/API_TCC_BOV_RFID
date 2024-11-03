package api.Bov_Corte.Model.Fazenda;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "foto_fazenda")
public class FotoFazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_foto_fazenda")
    private int pkFotoFazenda;

    @Column(name = "fk_fazenda")
    private int fkFazenda;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "bt_foto_fazenda")
    private byte[] btFotoFazenda;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

}