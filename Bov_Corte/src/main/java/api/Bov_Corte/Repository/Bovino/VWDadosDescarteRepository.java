package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.VWDadosDescarte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface VWDadosDescarteRepository extends CrudRepository<VWDadosDescarte, Integer> {

    List<VWDadosDescarte> findAllByFkFazenda(int fkFazenda);

}