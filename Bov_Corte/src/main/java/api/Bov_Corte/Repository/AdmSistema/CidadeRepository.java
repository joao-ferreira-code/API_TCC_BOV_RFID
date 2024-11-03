package api.Bov_Corte.Repository.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Integer> {

    List<Cidade> findAllByFkEstado(int fkEstado);


}