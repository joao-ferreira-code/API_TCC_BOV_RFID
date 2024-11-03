package api.Bov_Corte.Repository.Inventario;

import api.Bov_Corte.Model.Inventario.LoteVacina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface LoteVacinaRepository extends CrudRepository<LoteVacina, Integer> {

    List<LoteVacina> findAllByFkFazendaAndIsObrigatoria(int fkFazenda, boolean isObrigatoria);

    List<LoteVacina> findAllByFkFazendaAndIsAtiva(int fkFazenda, boolean isAtiva);

}