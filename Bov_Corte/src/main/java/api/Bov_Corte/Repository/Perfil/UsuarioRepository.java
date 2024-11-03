package api.Bov_Corte.Repository.Perfil;

import api.Bov_Corte.Model.Perfil.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByTxLogin(String txLogin);

    Usuario findByTxLoginAndTxSenha(String login, String senha);

    Usuario findByTxToken(String token);

    Usuario findByPkUsuarioAndTxLogin(int id, String login);

}