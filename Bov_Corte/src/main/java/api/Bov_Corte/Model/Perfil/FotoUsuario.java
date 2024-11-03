package api.Bov_Corte.Model.Perfil;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "foto_usuario")
public class FotoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_foto_usuario")
    private int pkFotoUsuario;

    @Column(name = "fk_usuario")
    private int fkUsuario;

    @Column(name = "bt_foto_usuario")
    private byte[] btFotoUsuario;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

}