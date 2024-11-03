package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.VWBovinoFazendaSimples;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VWBovinoFazendaSimplesRepository extends CrudRepository<VWBovinoFazendaSimples, Integer>  {

    @Query("Select bf from VWBovinoFazenda bf " +
            "where bf.fkFazenda = ?1 and bf.pkTagRfid = ?2 order by bf.bofDtCadastro")
    VWBovinoFazendaSimples getByCodeRFID(int fkFazenda, String pkBovino);

    @Query("Select bf from VWBovinoFazenda bf " +
            "where bf.fkFazenda = 15 and bf.pkBovino = 16 order by bf.bofDtCadastro")
    VWBovinoFazendaSimples getByCodeAnimal(int fkFazenda, int pkBovino);
}
