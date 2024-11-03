package api.Bov_Corte.Config.Security.Auditoria.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoggerService {

	@Autowired
	LoggerRepository loggerRepositoryl;

	public void create(Logger logger) {
		try {
			logger.setLogDtDatahora(new Date());
			loggerRepositoryl.save(logger);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
