package api.Bov_Corte.Repository.Perfil;

import api.Bov_Corte.Model.Perfil.RecuperarSenha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecuperarSenhaRepository extends CrudRepository<RecuperarSenha, Integer> {

    RecuperarSenha findByTxToken(String token);

}