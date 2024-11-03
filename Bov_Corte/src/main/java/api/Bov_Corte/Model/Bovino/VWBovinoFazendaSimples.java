package api.Bov_Corte.Model.Bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "vw_bovino_fazenda_simples")
public class VWBovinoFazendaSimples {

    @Id
    @Column(name = "pk_bovino_fazenda")
    private int pkBovinoFazenda;

    @Column(name = "fk_fazenda")
    private int fkFazenda;

    @Column(name = "bof_tx_obtencao")
    private String bofTxObtencao;

    @Column(name = "bof_tx_baixa")
    private String bofTxBaixa;

    @Column(name = "bof_is_ativa")
    private String bofIsAtiva;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "bof_dt_cadastro")
    private Date bofDtCadastro;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "bof_dt_baixa")
    private Date bofDtBaixa;

    @Column(name = "pk_bovino")
    private int pkBovino;

    @Column(name = "bov_tx_sexo")
    private String bovTxSexo;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "bov_dt_nascimento")
    private Date bovDtNascimento;

    @Column(name = "bov_tx_grau_sangue")
    private String bovTxGrauSangue;

    @Column(name = "bov_is_inseminacao")
    private String bovIsInseminacao;

    @Column(name = "bov_tx_avaliacao")
    private String bovTxAvaliacao;

    @Column(name = "pk_raca")
    private int pkRaca;

    @Column(name = "rac_tx_nome")
    private String racTxNome;

    @Column(name = "pk_tag_rfid")
    private String pkTagRfid;

    @Column(name = "tx_codigo_EPC")
    private String txCodigoEpc;

    @Column(name = "colab_cad_bovino_nome")
    private String colabCadBovinoNome;


}