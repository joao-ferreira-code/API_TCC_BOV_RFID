package api.Bov_Corte.Repository.Negociacao;

import api.Bov_Corte.Model.Negociacao.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface VendaRepository extends CrudRepository<Venda, Integer> {

}