package api.Bov_Corte.Config.Security.Autenticacao.jwt;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String username;
	private String password;

}