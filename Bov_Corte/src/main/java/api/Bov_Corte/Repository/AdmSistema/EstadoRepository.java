package api.Bov_Corte.Repository.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer> {

}