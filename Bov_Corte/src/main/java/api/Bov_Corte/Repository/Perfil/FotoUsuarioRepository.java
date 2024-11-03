package api.Bov_Corte.Repository.Perfil;

import api.Bov_Corte.Model.Perfil.FotoUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoUsuarioRepository extends CrudRepository<FotoUsuario, Integer> {

    FotoUsuario findAllByIsAtiva(boolean isAtiva);

    FotoUsuario findByFkUsuarioAndIsAtiva(int fkUsuario, boolean isAtiva);

}