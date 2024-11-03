package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.CompraBovino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface CompraBovinoRepository extends CrudRepository<CompraBovino, Integer> {

}