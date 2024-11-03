package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.DescarteBovino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface DescarteBovinoRepository extends CrudRepository<DescarteBovino, Integer> {

    @Query("Select db from DescarteBovino db " +
            "inner join BovinoFazenda bf on bf.pkBovinoFazenda = db.fkAnimalFazenda " +
            "where bf.fkFazenda = ?1 ")
    List<DescarteBovino> getAllByPkFazenda(int fkFazenda);

//====================================================================================================================//

    @Query(nativeQuery = true, value = "select " +
            " count(*) as qtdTotalAnimais, " +
            " SUM(CASE WHEN b.tx_sexo = 'M' THEN 1 ELSE 0 END) AS qtdAnimaisMachos, " +
            " SUM(CASE WHEN bf.tx_obtencao = 'COM' THEN 1 ELSE 0 END) AS qtdNrCompras, " +
            " SUM(CASE WHEN bf.tx_obtencao = 'NASC' THEN 1 ELSE 0 END) AS qtdNrNascimento " +
            " from bovino_fazenda bf " +
            " inner join bovino b on b.pk_bovino = bf.fk_animal " +
            " inner join descarte_bovino db on db.fk_animal_fazenda = bf.pk_bovino_fazenda " +
            " WHERE bf.fk_fazenda = ?1 and bf.dt_cadastro >= DATE_SUB( now(), INTERVAL ?2 month)")
    Object getResumoBovinoFazendaByIntervalo(int pkFazenda, int intervalo);

}