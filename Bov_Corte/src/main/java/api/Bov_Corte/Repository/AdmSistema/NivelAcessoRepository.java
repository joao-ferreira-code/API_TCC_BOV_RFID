package api.Bov_Corte.Repository.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.NivelAcesso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelAcessoRepository extends CrudRepository<NivelAcesso, Integer> {

}