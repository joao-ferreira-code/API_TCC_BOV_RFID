package api.Bov_Corte.Repository.Fazenda;

import api.Bov_Corte.Model.Fazenda.FotoFazenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoFazendaRepository extends CrudRepository<FotoFazenda, Integer> {

    @Query("Select ft From FotoFazenda ft " +
            "where ft.fkFazenda = ?1 and ft.isAtiva != 0 order by ft.dtCadastro desc ")
    FotoFazenda getFotoPerfilFazenda(int fkFazenda);

//====================================================================================================================//

    @Query("Select ft From FotoFazenda ft " +
            "where ft.fkFazenda = ?1 and ft.isAtiva != 0 order by ft.dtCadastro desc ")
    List<FotoFazenda> getAllFotoByAtivaFazenda(int fkFazenda);

//====================================================================================================================//

}