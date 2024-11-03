package api.Bov_Corte.Repository.Inventario;

import api.Bov_Corte.Model.Inventario.TagRFID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TagRFIDRepository extends CrudRepository<TagRFID, Integer> {

}