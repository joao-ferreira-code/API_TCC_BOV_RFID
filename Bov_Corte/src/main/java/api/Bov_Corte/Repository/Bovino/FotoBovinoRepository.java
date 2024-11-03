package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.FotoBovino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoBovinoRepository extends CrudRepository<FotoBovino, Integer> {

    @Query("Select ft From FotoBovino ft " +
            "where ft.fkBovino = ?1 order by ft.dtCadastro desc ")
    FotoBovino getFotoPerfilAnimal(int fkBovino);

    @Query("Select ft From FotoBovino ft " +
            "where ft.fkBovino = ?1 order by ft.dtCadastro desc ")
    List<FotoBovino> getAllFotoByAtivaBovino(int fkFazenda);

}