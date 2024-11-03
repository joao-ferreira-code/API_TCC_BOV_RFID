package api.Bov_Corte.Config.Security.Autenticacao.jwt;

import api.Bov_Corte.Model.Perfil.Usuario;
import api.Bov_Corte.Repository.Perfil.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

//====================================================================================================================//

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByTxLogin(username);
		//System.out.println("PERMISSOES CONCEDIDAS AO USUARIO"+usuario.getPermissaoUsuario().size());

		if (usuario != null) {
			return new User(usuario.getTxLogin(), usuario.getTxSenha(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("E-mail e/ou Senha Incorreta(s)!");
		}
	}

}
