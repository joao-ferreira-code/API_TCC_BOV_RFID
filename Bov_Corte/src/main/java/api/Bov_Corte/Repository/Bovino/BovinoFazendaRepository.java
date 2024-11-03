package api.Bov_Corte.Repository.Bovino;

import api.Bov_Corte.Model.Bovino.BovinoFazenda;
import api.Bov_Corte.Model.Bovino.ResumoCadastroBovino;
import api.Bov_Corte.Model.Bovino.VWBovinoFazenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface BovinoFazendaRepository extends CrudRepository<BovinoFazenda, Integer> {

    BovinoFazenda findByPkBovinoFazenda(int pkBovinoFazenda);

    @Query(nativeQuery = true, value = "select " +
            "count(*) as qtdTotalAnimais, " +
            "SUM(CASE WHEN b.tx_sexo = 'M' THEN 1 ELSE 0 END) AS qtdAnimaisMachos, " +
            "SUM(CASE WHEN bf.tx_obtencao = 'COM' THEN 1 ELSE 0 END) AS qtdNrCompras, " +
            "SUM(CASE WHEN bf.tx_obtencao = 'NASC' THEN 1 ELSE 0 END) AS qtdNrNascimento " +
            "from bovino_fazenda bf " +
            "inner join bovino b on b.pk_bovino = bf.fk_animal " +
            "WHERE bf.fk_fazenda = ?1 and " +
            "bf.dt_cadastro >= DATE_SUB( now(), INTERVAL ?2 month)")
    Object getResumoBovinoFazendaByIntervalo(int pkFazenda, int intervalo);

    @Query("select bf from VWBovinoFazenda as bf where bf.fkFazenda = ?1 and bf.bofIsAtiva = 0")
    List<VWBovinoFazenda> getAllByFkFazenda(int fkFazenda);

}