package api.Bov_Corte.Repository.Fazenda;

import api.Bov_Corte.Model.Fazenda.VWColaboradorFazenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface VWColaboradorFazendaRepository extends CrudRepository<VWColaboradorFazenda, Integer> {

    @Query("Select cf from VWColaboradorFazenda cf " +
            "where cf.fkFazenda = ?1 order by cf.isAtiva desc, cf.txNome")
    List<VWColaboradorFazenda> getAllColaboradorByFazenda(int fkFazenda);
}