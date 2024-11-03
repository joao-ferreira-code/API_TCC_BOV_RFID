package api.Bov_Corte.Model.Bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "compra_bovino")
public class CompraBovino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_compra_bovino")
    private int pkCompraBovino;

    @Column(name = "fk_animal_fazenda")
    private int fkAnimalFazenda;

    @Column(name = "fk_usuario_cadastrou")
    private int fkUsuarioCadastrou;

    @Column(name = "nr_pesagem")
    private int nrPesagem;

    @Column(name = "nr_valor")
    private int nrValor;

    @Column(name = "nr_valor_arroba")
    private int nrValorArroba;

    @Column(name = "is_pesagem_estimada")
    private boolean isPesagemEstimada;

    @Column(name = "is_ativa")
    private boolean isAtiva;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_compra")
    private Date dtCompra;

}