package api.Bov_Corte.Repository.Negociacao;

import api.Bov_Corte.Model.Negociacao.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface CompraRepository extends CrudRepository<Compra, Integer> {

}