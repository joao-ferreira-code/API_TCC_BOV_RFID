package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.VacinacaoBovino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface VacinacaoBovinoRepository extends CrudRepository<VacinacaoBovino, Integer> {

    @Query("Select vc from VacinacaoBovino vc " +
            "inner join BovinoFazenda bf on bf.pkBovinoFazenda = vc.fkAnimalFazenda " +
            "where bf.fkAnimal = ?1 and bf.fkFazenda = ?2 order by vc.dtVacinacao desc")
    List<VacinacaoBovino> getAllVacinacaoByBovinoAndFazeda(int fkAnimal, int fkFazenda);

//====================================================================================================================//

    @Query(nativeQuery = true, value = "select " +
            " count(*) as qtdTotalAnimais, " +
            " SUM(CASE WHEN b.tx_sexo = 'M' THEN 1 ELSE 0 END) AS qtdAnimaisMachos, " +
            " SUM(CASE WHEN bf.tx_obtencao = 'COM' THEN 1 ELSE 0 END) AS qtdNrCompras, " +
            " SUM(CASE WHEN bf.tx_obtencao = 'NASC' THEN 1 ELSE 0 END) AS qtdNrNascimento " +
            " from bovino_fazenda bf " +
            " inner join bovino b on b.pk_bovino = bf.fk_animal " +
            " inner join vacinacao_bovino vb on vb.fk_animal_fazenda = bf.pk_bovino_fazenda " +
            " WHERE bf.fk_fazenda = ?1 and bf.dt_cadastro >= DATE_SUB( now(), INTERVAL ?2 month)")
    Object getResumoBovinoFazendaByIntervalo(int pkFazenda, int intervalo);

}