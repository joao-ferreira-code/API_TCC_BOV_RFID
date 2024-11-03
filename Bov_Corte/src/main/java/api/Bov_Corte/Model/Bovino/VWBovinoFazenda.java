package api.Bov_Corte.Model.Bovino;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "vw_bovino_fazenda")
public class VWBovinoFazenda {

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

    @Column(name = "rac_tx_nome")
    private String racTxNome;

    @Column(name = "pk_raca")
    private String pkRaca;

    @Column(name = "pk_tag_rfid")
    private String pkTagRfid;

    @Column(name = "tx_codigo_EPC")
    private String txCodigoEpc;

    @Column(name = "pk_venda")
    private String pkVenda;

    @Column(name = "ven_nr_pesagem")
    private String venNrPesagem;

    @Column(name = "ven_nr_valor")
    private String venNrValor;

    @Column(name = "ven_nr_valor_arroba")
    private String venNrValorArroba;

    @Column(name = "ven_is_pesagem_estimada")
    private String venIsPesagemEstimada;

    @Column(name = "ven_is_ativa")
    private String venIsAtiva;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "ven_dt_cadastro")
    private Date venDtCadastro;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "ven_dt_venda")
    private Date venDtVenda;

    @Column(name = "pk_compra_bovino")
    private String pkCompraBovino;

    @Column(name = "cmp_nr_pesagem")
    private String cmpNrPesagem;

    @Column(name = "cmp_nr_valor")
    private String cmpNrValor;

    @Column(name = "cmp_nr_valor_arroba")
    private String cmpNrValorArroba;

    @Column(name = "cmp_is_pesagem_estimada")
    private String cmpIsPesagemEstimada;

    @Column(name = "cmp_is_ativa")
    private String cmpIsAtiva;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "cmp_dt_compra")
    private Date cmpDtCompra;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "cmp_dt_cadastro")
    private Date cmpDtCadastro;

    @Column(name = "pk_descarte_bovino")
    private String pkDescarteBovino;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dsb_dt_perca")
    private Date dsbDtPerca;

    @Column(name = "dsb_tx_motivo")
    private String dsbTxMotivo;

    @Column(name = "dsb_tx_observacao")
    private String dsbTxObservacao;

    @Column(name = "dsb_is_ativa")
    private String dsbIsAtiva;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dsb_dt_cadastro")
    private Date dsbDtCadastro;

    @Column(name = "colab_cad_bovino_nome")
    private String colabCadBovinoNome;

    @Column(name = "colab_cad_vend_nome")
    private String colabCadVendNome;

    @Column(name = "colab_cad_com_nome")
    private String colabCadComNome;

    @Column(name = "colab_cad_des_nome")
    private String colabCadDesNome;

}