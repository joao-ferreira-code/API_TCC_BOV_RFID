package api.Bov_Corte.Repository.Inventario;

import api.Bov_Corte.Model.Inventario.LoteTagRFID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface LoteTagRFIDRepository extends CrudRepository<LoteTagRFID, Integer> {

    List<LoteTagRFID> findAllByFkFazenda(int fkFazenda);


}