package api.Bov_Corte.Repository.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Raca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacaRepository extends CrudRepository<Raca, Integer> {

    @Query("Select rc from Raca rc order by rc.txNome")
    List<Raca> getAllRacaOrderByTxNome();
}