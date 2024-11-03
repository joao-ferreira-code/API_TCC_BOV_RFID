package api.Bov_Corte.Config.Security.Auditoria.log;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "log4j")
public class Logger {

		
	@Id
	@Column(name="log_nr_id")
	private long logNrId;
		
	@Column(name="log_tx_sistema")
	private String logTxSistema;
		
	@Column(name="log_tx_classe")
	private String logTxClasse;
		
	@Column(name="log_tx_metodo")
	private String logTxMetodo;
		
	@Column(name="log_tx_usuario")
	private String logTxUsuario;
		
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name="log_dt_datahora")
	private Date logDtDatahora;
		
	@Column(name="log_tx_status")
	private Integer logTxStatus;
		
	@Column(name="log_tx_ip")
	private String logTxIp;
		
	@Column(name="log_tx_parametros")
	private String logTxParametros;
}
