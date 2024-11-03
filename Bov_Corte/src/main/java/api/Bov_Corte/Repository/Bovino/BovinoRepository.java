package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.Bovino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface BovinoRepository extends CrudRepository<Bovino, Integer> {

    //List<Bovino> findAllByFkBovinoAndIsAtiva(int fkFazenda, boolean isAtiva);

}