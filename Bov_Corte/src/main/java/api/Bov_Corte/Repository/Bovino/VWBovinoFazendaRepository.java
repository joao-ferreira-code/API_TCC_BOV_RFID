package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.VWBovinoFazenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface VWBovinoFazendaRepository extends CrudRepository<VWBovinoFazenda, Integer> {

    @Query("Select bf from VWBovinoFazenda bf " +
            "where bf.fkFazenda = ?1 and bf.pkBovino = ?2 order by bf.bofDtCadastro")
    List<VWBovinoFazenda> getAllBovinoFazendaByCodeAnimal(int fkFazenda, int pkBovino);

//----------------------------------------------------------------------------------------------------------------//

    @Query("Select bf from VWBovinoFazenda bf " +
            "where bf.fkFazenda = ?1 and bf.pkTagRfid = ?2 order by bf.bofDtCadastro")
    List<VWBovinoFazenda> getAllBovinoFazendaByCodeRFID(int fkFazenda, String pkBovino);

//====================================================================================================================//


}