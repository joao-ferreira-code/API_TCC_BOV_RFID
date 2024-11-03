package api.Bov_Corte.Model.Bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "pesagem_bovino")
public class PesagemBovino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_pesagem_bovino")
    private int pkPesagemBovino;

    @Column(name = "fk_animal_fazenda")
    private int fkAnimalFazenda;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_pesagem")
    private Date dtPesagem;

    @Column(name = "nr_peso")
    private double nrPeso;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

}